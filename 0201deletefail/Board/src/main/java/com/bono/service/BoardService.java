package com.bono.service;

import java.util.List;

import com.bono.domain.BoardAttachVO;
import com.bono.domain.BoardVO;
import com.bono.domain.Criteria;

public interface BoardService {
	
	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long bno);
	
	public List<BoardVO> getList(Criteria criteria);
	
	public int getTotalCount(Criteria criteria);
	
	public List<BoardAttachVO> getAttachList(Long bno);
	
	public List<BoardVO> getLatestGallery(Criteria criteria);

}
