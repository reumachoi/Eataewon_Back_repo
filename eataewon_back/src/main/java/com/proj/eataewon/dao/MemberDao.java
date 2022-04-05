package com.proj.eataewon.dao;

import com.proj.eataewon.dto.BbsDto;
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

	public MemberDto login(MemberDto dto);

	public int addmember(MemberDto dto);

	public MemberBbsDto bbsGetUser(String id);

	public MemberDto getnickname(String id);

	public MemberDto detailMem(String id);

	public int updateMem(MemberDto dto);

	public int deleteMem(MemberDto dto);

	public String getProfilPic(String id);

	public int likePWriteUp(BbsDto dto);

	public int likePWriteDown(BbsDto dto);

	public int likePHeartUp(BbsDto dto);

	public int likePHeartDown(BbsDto bdto);

	public int likePScrapUp(BbsDto bdto);

	public int likePScrapDown(BbsDto dto);

}