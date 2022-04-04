package com.proj.eataewon.dao;

import com.proj.eataewon.dto.MemberBbsDto;
import com.proj.eataewon.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberDao {

	public List<MemberDto> allMember();

	public int getId(MemberDto dto);

	public int getIdApp(String id);

	public MemberDto login(MemberDto dto);

	public int addmember(MemberDto dto);

	public MemberBbsDto bbsGetUser(String id);
	public MemberDto getnickname(String id);

	public MemberDto detailMem(String id);

	public int updateMem(MemberDto dto);

	public int deleteMem(MemberDto dto);

	public String getProfilPic(String id);
}




