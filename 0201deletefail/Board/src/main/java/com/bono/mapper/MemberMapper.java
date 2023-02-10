package com.bono.mapper;

import com.bono.domain.MemberVO;

public interface MemberMapper {
	
	public MemberVO read(String userId);
	
	public int insert(MemberVO member);
	
	public int insertAuth(String userId);
	
	public int modify(MemberVO member);
}
