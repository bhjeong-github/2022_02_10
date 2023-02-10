package com.bono.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bono.domain.BoardAttachVO;
import com.bono.domain.BoardVO;
import com.bono.domain.Criteria;
import com.bono.mapper.BoardAttachMapper;
import com.bono.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper;
	private BoardAttachMapper attachMapper;
	

	
	@Override
	public void register(BoardVO board) {
		log.info("register...." + board);
		mapper.insert(board);
		
		if (board.getAttachList() == null || board.getAttachList().size() <= 0) {
			return;
		}
		board.getAttachList().forEach(attach -> {
			attach.setBno(board.getBno());
			attachMapper.insert(attach);
		});
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get .... " + bno);
		return mapper.read(bno);
		
	}
	@Transactional
	@Override
	public boolean modify(BoardVO board) {
		log.info("modify..." + board);
		attachMapper.deleteAll(board.getBno());
		boolean modifyResult = mapper.update(board) ==1;
		if (modifyResult = board.getAttachList() != null) {
			board.getAttachList().forEach(attach -> {
				attach.setBno(board.getBno());
				attachMapper.insert(attach);
			});
		}
		return modifyResult;	
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove..." + bno);
		
		attachMapper.deleteAll(bno);
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList(Criteria criteria) {
		criteria.calOffset();
		log.info("getList......");
		return mapper.getListWithPaging(criteria); 
	}

	@Override
	public int getTotalCount(Criteria criteria) {
		log.info("getTotalCount.....");
		return mapper.getTotalCount(criteria);
	}

	@Override
	public List<BoardAttachVO> getAttachList(Long bno) {
		log.info("get Attach list by bno " + bno);
		return attachMapper.findByBno(bno);
	}

	@Override
	public List<BoardVO> getLatestGallery(Criteria criteria) {
		log.info("getLatestGallery");
		return mapper.getLatestGallery(criteria);
	}
}
