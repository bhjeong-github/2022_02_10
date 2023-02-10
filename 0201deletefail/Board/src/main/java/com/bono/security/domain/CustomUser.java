package com.bono.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.bono.domain.MemberVO;

import lombok.Getter;

@Getter
public class CustomUser	extends User {
	private static final long serialVersionUID = 1L;
	private MemberVO member;
	
	public CustomUser (String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public CustomUser (MemberVO vo) {
		super(vo.getUserId(), vo.getUserPw(), vo.getAuthList().stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		this.member = vo;
	}
}

/* List<AuthVO> list = vo.getAuthList();
  List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
  for ( int i=0; i<list.size(); i++) {
  authList.add(new SimpleGrantedAuthority(list.get(0).getAuth()));
  } */
