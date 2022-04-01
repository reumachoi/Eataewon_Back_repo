package com.proj.eataewon.dao;

import java.util.List;

import com.proj.eataewon.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberDao {

	public List<MemberDto> allMember();

	public int getId(MemberDto dto);

	public MemberDto login(MemberDto dto);

	public int addmember(MemberDto dto);

	public MemberDto getnickname(String id);

	public MemberDto detailMem(String id);

	public int updateMem(MemberDto dto);
}




