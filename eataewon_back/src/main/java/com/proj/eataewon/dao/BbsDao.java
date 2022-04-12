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

    public int deleteScrap(ScrapDto dto);

    public int scrapBbsCnt(ScrapDto dto);

    public int deleteLike(LikeDto dto);

    public int likecntUpdate(LikeDto dto);

    public int likecntDown(LikeDto dto);

    public List<BbsFileDto> getBbsListFileSearchPage(BbsParam param);

    public BbsFileDto getBbsDetail(int seq);

    public boolean bbswriteImgup(BbsFileDto dto);

    public void readcountFile(int seq);

    public int updateBbsFile(BbsFileDto dto);

    public int deleteBbsFile(int seq);

    public int likeBbsFile(LikeDto dto);

    public List<BbsFileDto> likeBbsListFile(BbsFileDto dto);

    public int likebbsfileCnt(LikeDto dto);

    public int lpplusfilepoint(BbsFileDto fdto);

    public int likecntfileUpdate(LikeDto dto);

    public int likecntDownfile(LikeDto dto);

    public int lpminuspointfile(BbsFileDto fdto);

    public int deleteLikefile(LikeDto dto);

    public int scrapBbsCntfile(ScrapDto dto);

    public int scrpointupfile(BbsFileDto bdto);

    public int bbsScrapfile(ScrapDto dto);

    public List<BbsFileDto> scrapBbsListfile(BbsFileDto dto);

    public int deleteScrapfile(ScrapDto dto);

    public int scrpointminusfile(BbsFileDto dto);

    public int getBbsFileCount(BbsParam param);

    public int likepointupfile(BbsFileDto dto);

    public int likepointdownfile(BbsFileDto dto);

    public List<BbsFileDto> getBbsListFileSearchPageImg(BbsParam param);
}




