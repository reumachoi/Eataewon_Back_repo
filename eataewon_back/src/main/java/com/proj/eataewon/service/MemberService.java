
package com.proj.eataewon.service;

import java.util.List;

import com.proj.eataewon.dao.MemberDao;
import com.proj.eataewon.dto.MemberBbsDto;
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

    public boolean getId(String id) {
		System.out.println("+" + id + "+");
		int n = dao.getId(id);
		System.out.println(n);
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

	public 	MemberBbsDto bbsGetUser(String id){
		return dao.bbsGetUser(id);
	}

}












