
package com.proj.eataewon.dao;

import com.proj.eataewon.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BbsDao {

    public List<BbsDto> getBbsList();

    public int writeBbs(BbsDto dto);

    public void readcount(int seq);

    public void likeUpdate(int seq);

    public boolean bbswriteImgup(BbsDto dto);

    public BbsDto getBbs(int seq);

    public List<BbsDto> getBbsListSearch(BbsParam param);

    public List<BbsDto> getBbsListSearchPage(BbsParam param);

    public int getBbsCount(BbsParam param);

    public int updateBbs(BbsDto dto);

    public int deleteBbs(int seq);

    public int bbsScrap(ScrapDto dto);

    public List<BbsDto> scrapBbsList(BbsDto dto);

    public int likeBbs(LikeDto dto);

    public int likebbsCnt(LikeDto dto);

    public List<BbsDto> likeBbsList(BbsDto dto);

    public int deleteScarp(int seq);

    public int scrapBbsCnt(ScrapDto dto);

    public int deleteLike(int seq);

    public int likecntUpdate(LikeDto dto);


}


