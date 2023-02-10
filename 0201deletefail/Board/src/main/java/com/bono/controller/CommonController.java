package com.bono.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bono.domain.MemberVO;
import com.bono.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class CommonController {
	
	private MemberService service;
	
	@GetMapping("/eccessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied : " + auth);
		model.addAttribute("msg", "Access Denied");
	}
	
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		log.info("error : " + error);
		log.info("logout : " + logout);
		if (error != null) {
			model.addAttribute("error", "Login Error Check Your Account");
		}
		if (logout != null) {
			model.addAttribute("logout", "Logout!!");
		}
	}
	
	@GetMapping("/customLogout")
	public void logoutGET() {
		log.info("custom logout");
	}
	
	@PostMapping("/customLogout")
	public String logoutPost() {
		log.info("post custom logout");
		return "redirect:/customLogin";
	}
	
	// 회원가입
	@GetMapping("/customRegister")
	public void registerGet() {
		log.info("register........get..");
	}
	
	@PostMapping("/customRegister")
	public String registerPost(@ModelAttribute MemberVO member) {
		log.info("register.......post.....");
		log.info("register Member : " + member);
		service.register(member);
		service.registerAuth(member.getUserId());
		return "redirect:/customLogin";
	}
	//회원정보수정
	@GetMapping("/customModify")
	public void modifyGet() {
		log.info("register.....get..");
	}
	
	@PostMapping("/customModify")
	public String modifyPost(MemberVO member) {
		log.info("modify........post....");
		log.info("modify Member : " + member);
		service.modify(member);
		return "redirect:/";
	}
}
