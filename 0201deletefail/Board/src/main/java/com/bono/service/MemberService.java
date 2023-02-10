package com.bono.service;

import com.bono.domain.MemberVO;

public interface MemberService {
	public MemberVO get(String userId);
	
	public int register(MemberVO member);
	
	public int registerAuth(String userId);
	
	public int modify(MemberVO member);
	
}
