
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

	public boolean addmember(MemberDto dto) {
		System.out.println("Service addmember");

		int n = dao.addmember(dto);

		return n>0?true:false;
	}

	public MemberDto login(MemberDto dto) {

		return dao.login(dto);
	}
}












