package com.bono.mapper;

import org.apache.ibatis.annotations.Param;

import com.bono.domain.ReserveVO;

public interface HomeMapper {
	
	public int reserve(ReserveVO vo);
	
	public ReserveVO read(String reserveid);
	
	public int delete(String reserveid);
	
	public int existsById(String reserveid);
	
	public int existsBySameService(@Param("date")String date, @Param("title")String title, @Param("time")String time);

	

}
