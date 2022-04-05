package com.proj.eataewon.service;

import com.proj.eataewon.dao.AppMemberDao;
import com.proj.eataewon.dao.MemberDao;
import com.proj.eataewon.dto.BbsDto;
import com.proj.eataewon.dto.MemberBbsDto;
import com.proj.eataewon.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AppMemberService {
	
	@Autowired
	AppMemberDao dao;

	public boolean getIdApp(String id) {
		System.out.println("+" + id + "+");
		int n = dao.getIdApp(id);
		System.out.println(n);
		return n>0?true:false;
	}

	public String getEmailApp(String email) {
		System.out.println("+" + email + "+");
		String id = dao.getEmailApp(email);
		System.out.println("이메일로찾은 아이디 "+id);
		return id;
	}

	public Boolean resetPwd(MemberDto dto){
		int n = dao.resetPwd(dto);
		return n>0?true:false;
	}

	public boolean LikePWriteUp(String id){
		int n = dao.LikePWriteUp(id);
		return n>0?true:false;
	}

	public boolean LikePWriteDown(String id){
		int n = dao.LikePWriteDown(id);
		return n>0?true:false;
	}

	public boolean LikePHeartUp(String id){
		int n = dao.LikePHeartUp(id);
		return n>0?true:false;
	}

	public boolean LikePScrapUp(String id){
		int n = dao.LikePScrapUp(id);
		return n>0?true:false;
	}

	public boolean LikePHeartDown(String id){
		int n = dao.LikePHeartDown(id);
		return n>0?true:false;
	}

	public boolean LikePScrapDown(String id){
		int n = dao.LikePScrapDown(id);
		return n>0?true:false;
	}

	public MemberDto findUserData(MemberDto dto){
		return dao.findUserData(dto);
	}

	public boolean updateUserData(MemberDto dto){
		int n = dao.updateUserData(dto);
		return n>0?true:false;
	}
}







