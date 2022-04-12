package com.proj.eataewon.service;

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
	public MemberDto login(MemberDto dto) {
		System.out.println("login memberservice");
		return dao.login(dto);
	}

	public boolean addmember(MemberDto dto) {
		int n = dao.addmember(dto);
		return n>0?true:false;
	}

	public MemberBbsDto bbsGetUser(String id) {
		return dao.bbsGetUser(id);
	}

	public MemberDto getnickname(String id) {
		return dao.getnickname(id);
	}

	public MemberDto detailMem(String id) {
		return dao.detailMem(id);
	}

	public boolean updateMem(MemberDto dto) {
		int n = dao.updateMem(dto);
		return n>0?true:false;
	}

	public boolean deleteMem(MemberDto dto) {
		int n = dao.deleteMem(dto);
		return n>0?true:false;
	}

	public String getProfilPic(String id){
		return dao.getProfilPic(id);
	}

	public boolean likePWriteUp(BbsDto dto) {
		int n = dao.likePWriteUp(dto);
		return n>0?true:false;
	}

	public boolean likePWriteDown(BbsDto dto) {
		int n = dao.likePWriteDown(dto);
		return n>0?true:false;
	}

	public boolean likePHeartUp(BbsDto bdto) {
		int n = dao.likePHeartUp(bdto);
		return n>0?true:false;
	}


	public boolean likePHeartDown(BbsDto bdto) {
		int n = dao.likePHeartDown(bdto);
		return n>0?true:false;
	}

	public boolean likePScrapUp(BbsDto bdto) {
		int n = dao.likePScrapUp(bdto);
		return n>0?true:false;

	}

	public boolean likePScrapDown(BbsDto dto) {
		int n = dao.likePScrapDown(dto);
		return n>0?true:false;

	}
}