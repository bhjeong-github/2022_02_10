package com.bono.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bono.domain.ReserveVO;
import com.bono.service.CalendarService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/calendar/*")
public class CalendarController {
    
    @Autowired
    CalendarService service;
    

    @GetMapping("/calendarPage")
	public void calendarPage(Model model) {
		
	}

//    @GetMapping(value = "/event/{id}", 
//    			produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<CalendarVO>> getList(@PathVariable("id") String id) {
//		log.info("geteventList" + id);
//		List<CalendarVO> list = new ArrayList<>();
//		list.add(new CalendarVO("보노쌤", "2023-01-14", "2023-01-14", "true", "11:00"));
//		list.add(new CalendarVO("재운쌤", "2023-01-15", "2023-01-18", "false", "11:00"));
//		list.add(new CalendarVO("동수쌤", "2023-01-19", "2023-01-21", "false", "11:00"));
//		list.add(new CalendarVO("동수쌤", "2023-01-19T17:00:00", "", "", ""));
//		list.add(new CalendarVO("동수쌤", "2023-01-20", "", "", ""));
//		list.add(new CalendarVO("동수쌤", "2023-01-21", "", "", ""));
//		
//		return new ResponseEntity<>(list, HttpStatus.OK);
//	}
    
    @GetMapping(value = "/event/{resno}", 
				produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReserveVO>> getList(@PathVariable("resno") String resno) {
		log.info("geteventList" + resno);
		List<ReserveVO> list = service.getListEvent(null);
		log.info(list);
		return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping(value = "/sell/{resno}", 
			produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> addSell(@PathVariable("resno") String resno, @RequestParam("price") String price) {
	log.info("addSell" + resno);
	ReserveVO vo = service.get(resno);
	vo.setPrice(price);
//	log.info(vo.getResno() +" "+ vo.getDate() +" "+ vo.getTitle() +" "+ vo.getStyle());
	int insertCount = service.addSell(vo);
	log.info(insertCount);
	return insertCount == 1 ?
			new ResponseEntity<>("success", HttpStatus.OK) :
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
	@DeleteMapping(value = "/delete/{resno}", 
				   produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> adminRemove(@PathVariable("resno")String resno) {
		log.info("remove : " + resno);
		ReserveVO vo = service.get(resno);
		return service.adminRemove(resno) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

    
}