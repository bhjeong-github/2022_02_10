package com.bono.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bono.domain.SellVO;
import com.bono.mapper.AdminMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class AdminServiceImpl implements AdminService {
	
	private AdminMapper mapper;
	
	@Override
	public List<SellVO> getList(String start, String end) {
		log.info("getSellList.............");
		return mapper.adminSellList(start, end);
	}

}
