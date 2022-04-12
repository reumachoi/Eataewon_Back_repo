package com.proj.eataewon.dao;

import com.proj.eataewon.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AppBbsDao {

    public BbsDto getBbsListApp(int seq);

    public int writeBbsApp(BbsDto dto);

    public int readcountApp(int seq);

    public int checkUserLike(LikeDto dto);

    public int checkUserScrap(ScrapDto dto);

    public  List<BbsDto> findMyBbs(String id);

    public int likecntPlus(int seq);

    public int likecntMinus(int seq);

    public List<BbsDto> findBookmark(String id);
}




