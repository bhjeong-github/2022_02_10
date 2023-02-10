package com.bono.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bono.domain.BoardAttachVO;
import com.bono.domain.BoardVO;
import com.bono.domain.Criteria;
import com.bono.domain.PageDTO;
import com.bono.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	@GetMapping("/list")
	public void list (Criteria criteria, Model model) {
		log.info ("list" + criteria);
		int total = service.getTotalCount(criteria);
		model.addAttribute("list", service.getList(criteria));
		model.addAttribute("pageMaker", new PageDTO(criteria, total));
		log.info("total"+ total);
	}
	
	@GetMapping("/register")
	@PreAuthorize("isAuthenticated()")
	public void register() {
		log.info("register");
	}
	@PostMapping("/register")
	@PreAuthorize("isAuthenticated()")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register : " + board.getBno());
		if (board.getAttachList() != null) {
			board.getAttachList().forEach(attach -> log.info(attach));
		}
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
	
	
	@GetMapping({"/get","/modify"})
    public void get(@RequestParam("bno")Long bno, 
    		@ModelAttribute("criteria") Criteria criteria,
    		Model model) {
		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
    }
	
	/*@GetMapping("/modify")  // 수정1
    public void modify(BoardVO board, Model model) {
       	log.info("/modify");
       	model.addAttribute("board", service.modify(board));
	        
	}*/
	
	@PreAuthorize("principal.username == #board.writer")
	@PostMapping("/modify")	  // 수정2 이게맞음 post
	public String modify(BoardVO board, Criteria criteria, RedirectAttributes rttr) {
		log.info("modify : " + board);
		
		if (service.modify(board)) {
			rttr.addFlashAttribute("result" , "success");
		}
		/*rttr.addAttribute("pageNum", criteria.getPageNum());
		rttr.addAttribute("amount", criteria.getAmount());
		rttr.addAttribute("type", criteria.getType());
		rttr.addAttribute("keyword", criteria.getKeyword());*/
		
		return "redirect:/board/list" + criteria.getListLink();
	}
	
	@PreAuthorize("principal.username == #writer")
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno , Criteria criteria, RedirectAttributes rttr,
						@RequestParam("writer") String writer) {
		log.info("remove : " + bno);
		List<BoardAttachVO> attachList = service.getAttachList(bno);
		if (service.remove(bno)) {
			// delete Attach Files
			deleteFiles(attachList);
			rttr.addFlashAttribute("result" , "success");
		}
		/*rttr.addAttribute("pageNum", criteria.getPageNum());
		rttr.addAttribute("amount", criteria.getAmount());
		rttr.addAttribute("type", criteria.getType());
		rttr.addAttribute("keyword", criteria.getKeyword());*/
		
		return "redirect:/board/list" + criteria.getListLink();
	}
	private void deleteFiles(List<BoardAttachVO> attachList) {
		if (attachList == null || attachList.size() == 0) {
			return;
		}
		log.info("delete attach files..................");
		log.info(attachList);
		attachList.forEach(attach -> {
			try {
				Path file = Paths.get(
					"C:\\upload\\" + attach.getUploadPath() + "\\" + attach.getUuid() + "_" + attach.getFileName());
				Files.deleteIfExists(file);
				if (Files.probeContentType(file).startsWith("image")) {
					Path thumbNail = Paths.get("C:\\upload\\" + attach.getUploadPath() + "\\s_" + attach.getUuid() + "_"
						+ attach.getFileName());
					Files.delete(thumbNail);
				}
			} catch (Exception e) {
				log.error("delete file error" + e.getMessage());
			}
		});
	}
	
	@GetMapping(value = "/getAttachList", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachVO>> getAttachList(Long bno) {
		log.info("getAttachList" + bno);
		return new ResponseEntity<>(service.getAttachList(bno), HttpStatus.OK);
	}
	
	//게시물 리스트 - 첨부파일 리스트 불러오기
	@GetMapping(value = "/getAttachListOnList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<Long, List<BoardAttachVO>>> getAttachListOnList(@RequestParam(value="list[]") List<Long> list){
			log.info("getAttachListOnList" + list.stream().collect(Collectors.toList()));
			Map<Long, List<BoardAttachVO>> map = new HashMap<Long, List<BoardAttachVO>>();
			list.stream().forEach(bno->map.put(bno, service.getAttachList(bno)));
			return new ResponseEntity<>(map, HttpStatus.OK);
		}
	
	
}
