package com.proj.eataewon.dao;

import com.proj.eataewon.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Repository
public interface AppBbsDao {

    public BbsDto getBbsListSearchApp(BbsParam param); // 검색했을 경우 recyclerview

    public BbsDto getMarkerListApp();       // Search Map 데이터

    public ArrayList<BbsDto> getUpperBbsListApp();      // 홈 화면 상단

    public ArrayList<MemberBbsDto> getLowerBbsListApp();        // 홈 화면 하단 recyclerview

    public ArrayList<BbsDto> getSearchListApp();        // 검색 전 화면 recyclerview

    public BbsDto getBbsListApp(int seq);

    public int writeBbsApp(BbsDto dto);

    public int readcountApp(int seq);

    public int checkUserLike(LikeDto dto);

    public int checkUserScrap(ScrapDto dto);

    public  List<BbsDto> findMyBbs(String id);



}