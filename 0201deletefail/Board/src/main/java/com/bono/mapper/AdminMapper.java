package com.bono.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bono.domain.SellVO;

public interface AdminMapper {
	
	public List<SellVO> adminSellList(@Param("start")String start, @Param("end")String end);
}
