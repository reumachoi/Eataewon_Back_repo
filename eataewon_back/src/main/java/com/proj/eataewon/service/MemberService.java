package com.proj.eataewon.service;

import java.util.List;

import com.proj.eataewon.dao.MemberDao;
import com.proj.eataewon.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

		return dao.login(dto);
	}

    public boolean addmember(MemberDto dto) {
		int n = dao.addmember(dto);

		return n>0?true:false;
    }

	public MemberDto getnickname(String id) {
	return dao.getnickname(id);
	}

	public MemberDto detailMem(String id) {
		return dao.detailMem(id);
	}

	public boolean updateMem(MemberDto dto) {
		int n = dao.updateMem(dto);
		if(n > 0) {
			return true;
		}
		return false;
	}
}







