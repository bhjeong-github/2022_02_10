package com.bono.service;

import java.util.List;

import com.bono.domain.Criteria;
import com.bono.domain.ReplyPageDTO;
import com.bono.domain.ReplyVO;

public interface ReplyService {
	
	public int register(ReplyVO reply);
	
	public ReplyVO get(Long rno);
	
	public int modify(ReplyVO reply);
	
	public int remove(Long rno);
	
	public List<ReplyVO> getList(Criteria criteria, Long bno);
	
	public ReplyPageDTO getListPage(Criteria criteria, Long bno);
	
}
