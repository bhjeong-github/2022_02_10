package com.bono.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bono.domain.MemberVO;
import com.bono.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private PasswordEncoder pwEncoder;
	private MemberMapper mapper;
	
	// 아이디
	@Override
	public MemberVO get(String userId) {
		log.info("Member get......." + userId);
		return mapper.read(userId);
	}
	
	// 회원가입하기
	@Override
	public int register(MemberVO member) {
		member.setUserPw(pwEncoder.encode(member.getUserPw()));
		log.info("Member register......" + member);
		return mapper.insert(member);
	}
	
	@Override
	public int registerAuth(String userId) {
		log.info("Member register......." + userId);
		return mapper.insertAuth(userId);
	}

	// 회원정보 수정
	@Override
	public int modify(MemberVO member) {
		member.setUserPw(pwEncoder.encode(member.getUserPw()));
		log.info("Member register......" + member);
		return mapper.modify(member);
	}

}
