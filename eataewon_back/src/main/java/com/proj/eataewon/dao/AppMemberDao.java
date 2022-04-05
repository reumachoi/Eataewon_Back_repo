package com.proj.eataewon.dao;

import com.proj.eataewon.dto.BbsDto;
import com.proj.eataewon.dto.MemberBbsDto;
import com.proj.eataewon.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AppMemberDao {

    public int getIdApp(String id);

    public int LikePWriteUp(String id);

    public int LikePHeartUp(String id);

    public int LikePScrapUp(String id);

    public int LikePHeartDown(String id);

    public int LikePScrapDown(String id);
}