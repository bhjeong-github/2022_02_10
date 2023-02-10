package com.bono.mapper;

import java.util.List;

import com.bono.domain.ReserveVO;

public interface CalendarMapper {

	public List<ReserveVO> getListEvent(ReserveVO vo);
	
	public int addSell(ReserveVO vo);
	
	public int adminRemove(String resno);
	
	public ReserveVO read(String resno);
}
