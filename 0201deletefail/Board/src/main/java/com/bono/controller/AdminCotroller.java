package com.bono.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bono.domain.ReserveVO;
import com.bono.domain.SellVO;
import com.bono.service.AdminService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin/*")
public class AdminCotroller {
	
	@Autowired
	private AdminService service;
	
	@RequestMapping(value = "/adminHome", method = RequestMethod.GET)
	public void adminHome() {
		log.info("Admin Home load Successfull.");
	}
	
	@GetMapping(value = "/sellList/{start}/{end}",
				produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<SellVO>> getList(@PathVariable("start") String start, 
										  		@PathVariable("end") String end) {
		log.info("get List................");
	//	Criteria criteria = new Criteria(page,10);
		return new ResponseEntity<>(service.getList(start, end), HttpStatus.OK);
	}
	
	
	
	
}
