package com.proj.eataewon.controller;

import com.proj.eataewon.dto.MemberDto;
import com.proj.eataewon.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController  // @Controller + @ResponsBody -> Restful
public class MemberController {

	@Autowired
	MemberService service;

	@RequestMapping(value = "/base", method = RequestMethod.GET)
	public String base() {
		System.out.println("HelloController base()");
		return "base";
	}


	@RequestMapping(value="/getId", method= {RequestMethod.GET, RequestMethod.POST})
	public String getId(MemberDto dto) {
		System.out.println("MemberController getID");

		boolean b = service.getId(dto);
		if(b) {
			return "NO"; //1이상이란 말, 이미 아이디가 존재한다는 말이라서 사용이 안된다
		}
		return "OK";
	}

	@RequestMapping(value="/login", method= {RequestMethod.GET, RequestMethod.POST})
	public MemberDto login(MemberDto dto, HttpServletRequest req) {
		System.out.println("MemberController login");
		System.out.println(dto.toString());

		MemberDto mem = service.login(dto);

		//이렇게 사용할수 있다는 말
		req.getSession().setAttribute("login", mem);
		return mem;
	}

	//@RequestBody 코틀린 통신용
	@RequestMapping(value="/loginApp", method= RequestMethod.POST)
	public MemberDto loginApp(@RequestBody MemberDto dto) {
		System.out.println("MemberController login");
		System.out.println(dto.toString());

		MemberDto mem = service.login(dto);
		System.out.println(mem.toString());
		return mem;
	}

	

	//글에 저장된 아이디로 유저정보 가져오기
	@RequestMapping(value = "/bbsGetUser", method = RequestMethod.POST)
	public MemberBbsDto bbsGetUser(@RequestBody String id){
		System.out.println("MemberController bbsGetUser");
		System.out.println("String id: " + id);

		return service.bbsGetUser(id);
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
		return null;
	}
	
	@RequestMapping(value = "/getMemberList")
	public List<MemberDto> getMemberList(){
		System.out.println("HelloController getMemberList()");

		List<MemberDto> list = new ArrayList<MemberDto>();

		return list;
	}	
	
	@RequestMapping(value = "/dbTest")
	public List<MemberDto> dbTest(){
		System.out.println("HelloController dbTest()");
		
		List<MemberDto> list = service.allMember();
		
		return list;		
	}
/*
	@RequestMapping(value="/addmember", method= {RequestMethod.GET, RequestMethod.POST})
	public String addmember(MemberDto dto) {
		System.out.println("MemberController addmember");
		System.out.println("dto:" + dto.toString());
		boolean b = service.addmember(dto);
		System.out.println(dto.toString());
		if(b) {
			return "YES";
		}
		return "NO";
	}*/
	@RequestMapping(value="/addmember", method= {RequestMethod.GET, RequestMethod.POST})
	public String addmember(MemberDto dto) {
		System.out.println("MemberController addmember");
		System.out.println("dto:" + dto.toString());
		boolean b = service.addmember(dto);
		System.out.println(dto.toString());
		if(b) {
			return "YES";
		}
		return "NO";
	}

	//회원가입 가입 컨트롤러 추가
	@RequestMapping(value = "/addmemberApp", method = { RequestMethod.GET, RequestMethod.POST })
	public String addmemberApp(@RequestBody MemberDto dto) {

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










