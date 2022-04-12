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
import java.util.Date;
import java.util.List;

@RestController  // @Controller + @ResponsBody -> Restful
public class AppMemberController {

	@Autowired
	AppMemberService service;

	@Autowired
	MemberService mservice;

	//아이디 중복확인
	//동일한 아이디를 가진 유저가 있는지 (아이디비번찾기)
	@RequestMapping(value="/getIdApp", method= RequestMethod.POST )
	public String getIdApp(@RequestBody String id) {
		System.out.println("MemberController getID" + id);

		boolean b = service.getIdApp(id);
		if(b) {
			return "NO"; //1이상이란 말, 이미 아이디가 존재한다는 말이라서 사용이 안된다
		}
		return "OK";
	}

	//동일한 이메일을 가진 유저가 있는지 (아이디비번찾기)
	@RequestMapping(value="/getEmailApp", method= RequestMethod.POST )
	public String getEmailApp(@RequestBody String email) {
		System.out.println("MemberController getEailApp" + email);

		return service.getEmailApp(email);
	}

	//로그인 체크
	@RequestMapping(value="/loginApp", method= RequestMethod.POST)
	public MemberDto loginApp(@RequestBody MemberDto dto) {
		System.out.println("MemberController login");
		System.out.println(dto.toString());

		MemberDto mem = mservice.login(dto);
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
		System.out.println("AppMemberController bbsGetUser");
		System.out.println("String id: " + id);

		return mservice.bbsGetUser(id);
	}

	//글쓴이 프로필사진 가져오기
	@RequestMapping(value="/getProfilPicApp", method=RequestMethod.POST)
	public String getProfilPic(@RequestBody String id){
		System.out.println("AppMemberController getProfilPic "+id);
		String pic = mservice.getProfilPic(id);
		return pic;
	}

	//아이디찾기후 비밀번호 재설정
	@RequestMapping(value = "/resetPwd", method = RequestMethod.POST)
	public Boolean resetPwd(@RequestBody MemberDto dto){
		System.out.println("AppMemberController resetPwd "+dto);
		boolean b = service.resetPwd(dto);
		System.out.println("비밀번호 재설정 성공/실패?? " + b);
		return b;
	}

	@RequestMapping(value="/LikePWriteUp", method=RequestMethod.POST)
	public Boolean LikePWriteUp(@RequestBody String id){
		System.out.println("AppMemberController LikePWriteUp " + id);

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

	@RequestMapping(value="/LikePWriteDown", method=RequestMethod.POST)
	public Boolean LikePWriteDown(@RequestBody String id){
		System.out.println("AppMemberController LikePWriteUp " + id);

		return service.LikePWriteDown(id);
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

	@RequestMapping(value="findUserData", method = RequestMethod.POST)
	public MemberDto findUserData(@RequestBody MemberDto dto){
		System.out.println("AppMemberController findUserData "+dto);
		return service.findUserData(dto);
	}

	@RequestMapping(value = "updateUserData", method = RequestMethod.POST)
	public Boolean updateUserData(@RequestBody MemberDto dto){
		System.out.println("AppMemberController updateUserData "+dto);
		return service.updateUserData(dto);
	}

	//회원 탈퇴하기
	@RequestMapping(value = "/deleteMemApp", method = {RequestMethod.GET, RequestMethod.POST} )
	public String deleteMem(@RequestBody MemberDto dto) {
		System.out.println("MemberController deleteMem " + new Date());
		System.out.println("MemberController deleteMem  " + dto.getId() + dto.getPwd() +new Date());

		boolean b = mservice.deleteMem(dto);
		if(b) {
			return "OK";
		}
		return "NO";
	}

	// 회원 사진 DB
	@RequestMapping (value = "/updateUserProfilPic", method =  {RequestMethod.GET, RequestMethod.POST})
	public  boolean updateUserProfilPic(@RequestBody MemberDto dto){
		System.out.println("MemberController updateUserProfilPic "+dto.toString());
		return service.updateUserProfilPic(dto);
	}
}










