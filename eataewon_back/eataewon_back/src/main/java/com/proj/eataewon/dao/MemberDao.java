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
}




