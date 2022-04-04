package com.proj.eataewon.service;

import com.proj.eataewon.dao.MemberDao;
import com.proj.eataewon.dto.MemberBbsDto;
import com.proj.eataewon.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberService {
	
	@Autowired
    MemberDao dao;

	public List<MemberDto> allMember() {
		return dao.allMember();
	}

    public boolean getId(MemberDto dto) {
		int n = dao.getId(dto);

		return n>0?true:false;
    }

	public boolean getIdApp(String id) {
		System.out.println("+" + id + "+");
		int n = dao.getIdApp(id);
		System.out.println(n);
		return n>0?true:false;
	}

	public MemberDto login(MemberDto dto) {

		return dao.login(dto);
	}

    public boolean addmember(MemberDto dto) {
		int n = dao.addmember(dto);

		return n>0?true:false;
    }

	public MemberBbsDto bbsGetUser(String id){
		return dao.bbsGetUser(id);
	}

	public boolean LikePWriteUp(String id){
		int n = dao.likePWriteUp(id);
		return n>0?true:false;
	}

	public boolean LikePHeartUp(String id){
		int n = dao.likePHeartUp(id);
		return n>0?true:false;
	}

	public boolean LikePScrapUp(String id){
		int n = dao.likePScrapUp(id);
		return n>0?true:false;
	}

	public boolean LikePHeartDown(String id){
		int n = dao.likePHeartDown(id);
		return n>0?true:false;
	}

	public boolean LikePScrapDown(String id){
		int n = dao.likePScrapDown(id);
		return n>0?true:false;
	}
}







