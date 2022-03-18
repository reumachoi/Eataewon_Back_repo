package com.proj.eataewon.controller;

import java.util.ArrayList;
import java.util.List;

import com.proj.eataewon.dto.MemberDto;
import com.proj.eataewon.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController  // @Controller + @ResponsBody -> Restful
public class HelloController {

	@Autowired
	MemberService service;

	@RequestMapping(value = "/base", method = RequestMethod.GET)
	public String base() {
		System.out.println("HelloController base()");
		return "base";
	}		
	
	@RequestMapping(value = "/connParamGet")
	public String connParamGet(String title) {
		System.out.println("HelloController connParamGet()");
		System.out.println("title:" + title);
		
		return "통신성공";	
	}
	
	@RequestMapping(value = "/getMember")
	public MemberDto getMember() {
		System.out.println("HelloController getMember()");
		//MemberDto dto = new MemberDto("abc", "123", "AAA", "aa@naver.com", 1);
		return null;
	}
	
	@RequestMapping(value = "/getMemberList")
	public List<MemberDto> getMemberList(){
		System.out.println("HelloController getMemberList()");

		List<MemberDto> list = new ArrayList<MemberDto>();

		/*
		list.add(new MemberDto("abc", "123", "AAA", "aa@naver.com", 1));
		list.add(new MemberDto("bcd", "234", "BBB", "bb@naver.com", 3));
		list.add(new MemberDto("cde", "345", "CCC", "cc@naver.com", 1));
		*/
		return list;
	}	
	
	@RequestMapping(value = "/dbTest")
	public List<MemberDto> dbTest(){
		System.out.println("HelloController dbTest()");
		
		List<MemberDto> list = service.allMember();
		
		return list;		
	}
	
	
}










