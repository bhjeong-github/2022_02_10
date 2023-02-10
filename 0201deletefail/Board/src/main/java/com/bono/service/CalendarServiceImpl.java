package com.bono.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bono.domain.ReserveVO;
import com.bono.mapper.CalendarMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class CalendarServiceImpl implements CalendarService {

	private CalendarMapper mapper;
	
	@Override
	public List<ReserveVO> getListEvent(ReserveVO vo) {
		log.info("getEvent...........");
		return mapper.getListEvent(vo);
	}

	@Override
	public int addSell(ReserveVO vo) {
		return mapper.addSell(vo);
	}

	@Override
	public ReserveVO get(String resno) {
		log.info("get........");
		return mapper.read(resno);
	}

	@Override
	public int adminRemove(String resno) {
		log.info("adminDelete.....");
		return mapper.adminRemove(resno);
	}
		
}
