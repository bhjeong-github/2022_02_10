package com.bono.service;

import java.util.List;

import com.bono.domain.ReserveVO;

public interface CalendarService {

	public List<ReserveVO> getListEvent(ReserveVO vo);
	
	public int addSell(ReserveVO vo);
	
	public int adminRemove(String resno);
	
	public ReserveVO get(String resno);
}
