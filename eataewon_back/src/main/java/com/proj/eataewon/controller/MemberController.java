package com.proj.eataewon.controller;

import com.proj.eataewon.dto.MemberDto;
import com.proj.eataewon.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

@RestController  // @Controller + @ResponsBody -> Restful
public class MemberController {

	@Autowired
	MemberService service;

	//@RequestBody 코틀린 통신용
	@RequestMapping(value="/getId", method= {RequestMethod.GET, RequestMethod.POST})
	public String getId(@RequestBody MemberDto dto) {
		System.out.println("MemberController getID");

		boolean b = service.getId(dto);
		if(b) {
			return "NO"; //1이상이란 말, 이미 아이디가 존재한다는 말이라서 사용이 안된다
		}
		return "OK";
	}

	//@RequestBody 코틀린 통신용
	@RequestMapping(value="/login", method= {RequestMethod.GET, RequestMethod.POST})
	public MemberDto login(@RequestBody MemberDto dto, HttpServletRequest req) {
		System.out.println("MemberController login");
		System.out.println(dto.toString());

		MemberDto mem = service.login(dto);

		//이렇게 사용할수 있다는 말
		req.getSession().setAttribute("login", mem);

		return mem;
	}

	//회원가입 가입 컨트롤러 추가
	@RequestMapping(value = "/addmember", method = { RequestMethod.GET, RequestMethod.POST })
	public String addmember(@RequestBody MemberDto dto) {

		System.out.println("MemberController addmember");
		System.out.println("dto :::  "+dto.toString());

		boolean b = service.addmember(dto);

		if (b) {
			return "yes";
		} else {
			return "no";
		}
	}
}










