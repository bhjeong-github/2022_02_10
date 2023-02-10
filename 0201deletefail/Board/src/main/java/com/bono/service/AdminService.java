package com.bono.service;

import java.util.List;

import com.bono.domain.SellVO;

public interface AdminService {
	
	public List<SellVO> getList(String start, String end);

}
