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

	public int likePWriteUp(String id);

	public int likePHeartUp(String id);

	public int likePScrapUp(String id);

	public int likePHeartDown(String id);

	public int likePScrapDown(String id);

	public String getProfilPic(String id);
}




