package com.proj.eataewon.controller;

import com.proj.eataewon.dto.*;
import com.proj.eataewon.service.AppBbsService;
import com.proj.eataewon.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;


@RestController
public class AppBbsController {

    @Autowired
    AppBbsService service;

    @Autowired
    BbsService bservice;

    @RequestMapping(value = "/getBbsListApp", method =  RequestMethod.POST)
    public BbsDto getBbsListApp(@RequestBody int seq) {
        System.out.println("BbsController getBbsList " + seq);
        System.out.println(service.getBbsListApp(seq).toString());

        return service.getBbsListApp(seq);
    }

    @RequestMapping(value = "/bbswriteApp", method = {RequestMethod.GET, RequestMethod.POST})
    public int bbswriteApp(@RequestBody BbsDto dto) {
        System.out.println("BbsController bbswrite " + new Date());

        int seq = service.writeBbsApp(dto);
        return seq;
    }


    @RequestMapping(value = "/plustReadcntApp", method = RequestMethod.POST)
    public String plustReadcntApp(@RequestBody int seq) {
        System.out.println(seq);
        System.out.println("BbsController plustReadcntApp " + new Date());
        String res = service.readcountApp(seq);
        System.out.println(res);
        return res;
    }


    @RequestMapping(value = "/bbsdeleteApp", method = {RequestMethod.GET, RequestMethod.POST})
    public Boolean bbsdeleteApp(@RequestBody int seq) {
        System.out.println("BbsController bbsdeleteApp " + new Date());

        Boolean b = bservice.deleteBbs(seq);
        System.out.println("삭제결과 불리안값 " + b);
        return b;
    }

    //스크랩했을때 스크랩 테이블 추가
    @RequestMapping(value = "/bbsScrapApp", method = {RequestMethod.GET, RequestMethod.POST})
    public boolean bbsScrapApp(@RequestBody ScrapDto dto) {
        System.out.println("BbsController bbsScrapApp " + new Date());

        return bservice.bbsScrap(dto);
    }

    //스크랩취소
    @RequestMapping(value = "/deleteBbsScrapApp", method = {RequestMethod.GET, RequestMethod.POST})
    public Boolean deleteBbsScrapApp(@RequestBody ScrapDto dto) {
        System.out.println("BbsController deleteBbsScrapApp " + new Date());

        return bservice.deleteScrap(dto);
    }

    //좋아요했을때 좋아요 테이블 추가
    @RequestMapping(value = "/bbsLikeApp", method = {RequestMethod.GET, RequestMethod.POST})
    public boolean bbsLikeApp(@RequestBody LikeDto dto) {
        System.out.println("BbsController bbsLikeApp " + new Date());

        return bservice.likeBbs(dto);
    }

    //좋아요취소
    @RequestMapping(value = "/deleteBbsLikeApp", method = {RequestMethod.GET, RequestMethod.POST})
    public Boolean deleteBbsLikeApp(@RequestBody LikeDto dto) {
        System.out.println("BbsController deleteBbsLikeApp " + new Date());

        return bservice.deleteLike(dto);
    }

    //로그인유저가 현재 상세글을 이미 좋아요했는지
    @RequestMapping(value = "/checkUserLike", method = {RequestMethod.GET, RequestMethod.POST})
    public Boolean checkUserLike(@RequestBody LikeDto dto){
        System.out.println("BbsController checkUserLike " + new Date());
        return service.checkUserLike(dto);
    }

    //로그인유저가 현재 상세글을 이미 스크랩했는지
    @RequestMapping(value = "/checkUserScrap", method = {RequestMethod.GET, RequestMethod.POST})
    public Boolean checkUserScrap(@RequestBody ScrapDto dto){
        System.out.println("BbsController checkUserScrap " + new Date());
        return service.checkUserScrap(dto);
    }
}
