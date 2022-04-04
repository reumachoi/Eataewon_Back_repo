package com.proj.eataewon.controller;

import com.proj.eataewon.dto.MemberBbsDto;
import com.proj.eataewon.dto.MemberDto;
import com.proj.eataewon.service.AppMemberService;
import com.proj.eataewon.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController  // @Controller + @ResponsBody -> Restful
public class AppMemberController {

	@Autowired
	AppMemberService service;

	@Autowired
	MemberService mservice;

	//아이디 중복확인
	@RequestMapping(value="/getIdApp", method= RequestMethod.POST )
	public String getIdApp(@RequestBody String id) {
		System.out.println("MemberController getID" + id);

		boolean b = service.getIdApp(id);
		if(b) {
			return "NO"; //1이상이란 말, 이미 아이디가 존재한다는 말이라서 사용이 안된다
		}
		return "OK";
	}


	//로그인 체크
	@RequestMapping(value="/loginApp", method= RequestMethod.POST)
	public MemberDto loginApp(@RequestBody MemberDto dto) {
		System.out.println("MemberController login");
		System.out.println(dto.toString());

		MemberDto mem = mservice.login(dto);
		System.out.println(mem.toString());
		return mem;
	}

	//회원가입 가입
	@RequestMapping(value = "/addmemberApp", method = { RequestMethod.GET, RequestMethod.POST })
	public String addmemberApp(@RequestBody MemberDto dto) {

		System.out.println("MemberController addmember");
		System.out.println("dto :::  "+dto.toString());

		boolean b = mservice.addmember(dto);

		if (b) {
			return "yes";
		} else {
			return "no";
		}
	}

	//글에 저장된 아이디로 유저정보 가져오기
	@RequestMapping(value = "/bbsGetUser", method = RequestMethod.POST)
	public MemberBbsDto bbsGetUser(@RequestBody String id){
		System.out.println("MemberController bbsGetUser");
		System.out.println("String id: " + id);

		return mservice.bbsGetUser(id);
	}

	//글쓴이 프로필사진 가져오기	@RequestMapping(value="getProfilPicApp", method=RequestMethod.POST)
	public String getProfilPic(@RequestBody String id){
		System.out.println("MemberController getProfilPic "+id);
		String pic = mservice.getProfilPic(id);
		return pic;
	}

	@RequestMapping(value="/LikePWriteUp", method=RequestMethod.POST)
	public Boolean LikePWriteUp(@RequestBody String id){
		System.out.println("MemberController LikePWriteUp " + id);

		return service.LikePWriteUp(id);
	}

	@RequestMapping(value="/LikePHeartUp", method=RequestMethod.POST)
	public Boolean LikePHeartUp(@RequestBody String id){
		System.out.println("MemberController LikePHeartUp " + id);

		return service.LikePHeartUp(id);
	}

	@RequestMapping(value="/LikePScrapUp", method=RequestMethod.POST)
	public Boolean LikePScrapUp(@RequestBody String id){
		System.out.println("MemberController LikePScrapUp " + id);

		return service.LikePScrapUp(id);
	}

	@RequestMapping(value="/LikePHeartDown", method=RequestMethod.POST)
	public Boolean LikePHeartDown(@RequestBody String id){
		System.out.println("MemberController LikePHeartUp " + id);

		return service.LikePHeartDown(id);
	}

	@RequestMapping(value="/LikePScrapDown", method=RequestMethod.POST)
	public Boolean LikePScrapDown(@RequestBody String id){
		System.out.println("MemberController LikePScrapUp " + id);

		return service.LikePScrapDown(id);
	}

}










