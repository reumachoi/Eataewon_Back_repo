package com.proj.eataewon.dao;

import com.proj.eataewon.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Repository
public interface AppBbsDao {

    public ArrayList<BbsDto> getUpperBbsListApp();

    public ArrayList<BbsDto> getLowerBbsListApp();

    public ArrayList<BbsDto> getBbsListApp();

    public int writeBbsApp(BbsDto dto);

    public int readcountApp(int seq);



}