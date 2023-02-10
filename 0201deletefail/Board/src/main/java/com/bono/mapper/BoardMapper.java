package com.bono.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bono.domain.BoardVO;
import com.bono.domain.Criteria;

public interface BoardMapper {
	
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria criteria);
	
	public int getTotalCount(Criteria criteria);
	
	public void insert(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public Integer update(BoardVO board);
	
	public Integer delete(Long bno);
	
	public void updateReplyCnt(@Param("bno") Long bno,
								@Param("amount") int amount);
	
	//메인페이지에 최신글 불러오기
	public List<BoardVO> getLatestGallery(Criteria criteria); 
	
}	
