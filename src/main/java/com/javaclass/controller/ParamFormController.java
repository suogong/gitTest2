package com.javaclass.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaclass.model.MemberVO;

@Controller
public class ParamFormController {

	@RequestMapping("param.do")
	public void param(int id, int age) {
	//public void param(MemberVO vo) {
		System.out.println("클라이언트부터넘어오는 파라메터");
	//	System.out.println(vo.getId() + "/" + vo.getAge());
	}
	
	@RequestMapping("paramForm.do")
	//*********************************
	// 스프링에서 세션처리는 함수의 파라메터로 HttpSession을 지정만 하면 된다.
	public void paramForm(MemberVO memberVO, HttpSession session) {
		//*******************
		// 실제로는 DB에 있는 아이디와 비밀번호 검색함
		int dbId = 1234;
		String dbPw = "javassem";
				
		// 비교
		if( dbId == memberVO.getId() && dbPw.equals(memberVO.getName())) {
			System.out.println("로그인성공");
			session.setAttribute("login", dbId);
		}
	}
}
