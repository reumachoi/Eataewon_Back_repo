package com.proj.eataewon.controller;

import com.proj.eataewon.dto.BbsDto;
import com.proj.eataewon.dto.MemberDto;
import com.proj.eataewon.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
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

	//회원가입
	/*@RequestMapping(value="/addmember", method= {RequestMethod.GET, RequestMethod.POST})
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

	//닉네임 불러오기
	@RequestMapping(value = "/getnickname", method = {RequestMethod.GET, RequestMethod.POST} )
	public MemberDto getnickname(String id) {
		System.out.println("getnickname " + id.toString() + new Date());

		return service.getnickname(id);
	}

	//회원 상세 정보 불러오기
	@RequestMapping(value = "/detailMem", method = {RequestMethod.GET, RequestMethod.POST} )
	public MemberDto detailMem(String id) {
		System.out.println("MemberDto MemberDto " + new Date());

		return service.detailMem(id);
	}
	
	//회원정보 수정하기
	@RequestMapping(value = "/updateMem", method = {RequestMethod.GET, RequestMethod.POST} )
	public String updateMem(MemberDto dto) {
		System.out.println("MemberDto dto updateMem " + new Date());

		boolean b = service.updateMem(dto);
		System.out.println("@@@@@@@@@@dto@@@@@@@@@"+dto.toString());
		if(b) {
			return "OK";
		}
		return "NO";
	}

	//회원 탈퇴하기
	@RequestMapping(value = "/deleteMem", method = {RequestMethod.GET, RequestMethod.POST} )
	public String deleteMem(MemberDto dto) {
		System.out.println("MemberController deleteMem " + new Date());
		System.out.println("MemberController deleteMem  " + dto.getId() + dto.getPwd() +new Date());

		boolean b = service.deleteMem(dto);
		if(b) {
			return "OK";
		}
		return "NO";
	}



}










