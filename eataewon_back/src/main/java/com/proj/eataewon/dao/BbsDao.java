package com.proj.eataewon.dao;

import com.proj.eataewon.dto.BbsDto;
import com.proj.eataewon.dto.BbsParam;
import com.proj.eataewon.dto.MemberDto;
import com.proj.eataewon.dto.ScrapDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BbsDao {

    public List<BbsDto> getBbsList();

    public int writeBbs(BbsDto dto);

    public void readcount(int seq);

    public BbsDto getBbs(int seq);

    public List<BbsDto> getBbsListSearch(BbsParam param);

    public List<BbsDto> getBbsListSearchPage(BbsParam param);

    public int getBbsCount(BbsParam param);

    public int updateBbs(BbsDto dto);

    public int deleteBbs(int seq);

    int bbsScrap(ScrapDto dto);

    List<BbsDto> scrapBbsList();
}




