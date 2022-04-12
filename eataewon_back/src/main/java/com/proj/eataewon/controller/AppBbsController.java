package com.proj.eataewon.controller;

import com.proj.eataewon.dto.*;
import com.proj.eataewon.service.AppBbsService;
import com.proj.eataewon.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;


@RestController
public class AppBbsController {

    @Autowired
    AppBbsService service;

    @Autowired
    BbsService bservice;

    @RequestMapping(value = "/getBbsListApp", method =  RequestMethod.POST)
    public BbsDto getBbsListApp(@RequestBody int seq) {
        System.out.println("AppBbsController getBbsList " + seq);
        System.out.println(service.getBbsListApp(seq).toString());

        return service.getBbsListApp(seq);
    }

    @RequestMapping(value = "/bbswriteApp", method = {RequestMethod.GET, RequestMethod.POST})
    public int bbswriteApp(@RequestBody BbsDto dto) {
        System.out.println("AppBbsController bbswrite " + dto.toString());

        int seq = service.writeBbsApp(dto);
        System.out.println("글쓰기 완료후 넘어온 seq: "+seq);
        return seq;
    }

    @RequestMapping(value="/bbsupdateApp", method = RequestMethod.POST)
    public Boolean bbsupdateApp(@RequestBody BbsDto dto){
        System.out.println("AppBbsController bbsupdateApp " + dto.toString());
        Boolean b = bservice.updateBbs(dto);
        System.out.println("글수정 결과: "+b);
        return b;
    }

    @RequestMapping(value = "/plustReadcntApp", method = RequestMethod.POST)
    public String plustReadcntApp(@RequestBody int seq) {
        System.out.println(seq);
        System.out.println("AppBbsController plustReadcntApp " + new Date());
        String res = service.readcountApp(seq);
        System.out.println(res);
        return res;
    }


    @RequestMapping(value = "/bbsdeleteApp", method = {RequestMethod.GET, RequestMethod.POST})
    public Boolean bbsdeleteApp(@RequestBody int seq) {
        System.out.println("AppBbsController bbsdeleteApp " + new Date());

        Boolean b = bservice.deleteBbs(seq);
        System.out.println("삭제결과 불리안값 " + b);
        return b;
    }

    //스크랩했을때 스크랩 테이블 추가
    @RequestMapping(value = "/bbsScrapApp", method = {RequestMethod.GET, RequestMethod.POST})
    public boolean bbsScrapApp(@RequestBody ScrapDto dto) {
        System.out.println("AppBbsController bbsScrapApp " + new Date());

        return bservice.bbsScrap(dto);
    }

    //스크랩취소
    @RequestMapping(value = "/deleteBbsScrapApp", method = {RequestMethod.GET, RequestMethod.POST})
    public Boolean deleteBbsScrapApp(@RequestBody ScrapDto dto) {
        System.out.println("AppBbsController deleteBbsScrapApp " + new Date());

        return bservice.deleteScrap(dto);
    }

    //좋아요했을때 좋아요 테이블 추가
    @RequestMapping(value = "/bbsLikeApp", method = {RequestMethod.GET, RequestMethod.POST})
    public boolean bbsLikeApp(@RequestBody LikeDto dto) {
        System.out.println("AppBbsController bbsLikeApp " + new Date());

        return bservice.likeBbs(dto);
    }

    //좋아요취소
    @RequestMapping(value = "/deleteBbsLikeApp", method = {RequestMethod.GET, RequestMethod.POST})
    public Boolean deleteBbsLikeApp(@RequestBody LikeDto dto) {
        System.out.println("AppBbsController deleteBbsLikeApp " + new Date());

        return bservice.deleteLike(dto);
    }

    //로그인유저가 현재 상세글을 이미 좋아요했는지
    @RequestMapping(value = "/checkUserLike", method = {RequestMethod.GET, RequestMethod.POST})
    public Boolean checkUserLike(@RequestBody LikeDto dto){
        System.out.println("AppBbsController checkUserLike " + new Date());
        return service.checkUserLike(dto);
    }

    //로그인유저가 현재 상세글을 이미 스크랩했는지
    @RequestMapping(value = "/checkUserScrap", method = {RequestMethod.GET, RequestMethod.POST})
    public Boolean checkUserScrap(@RequestBody ScrapDto dto){
        System.out.println("AppBbsController checkUserScrap " + new Date());
        return service.checkUserScrap(dto);
    }


    @RequestMapping(value="/findMyBbs",method = RequestMethod.POST)
    public List<BbsDto> findMyBbs(@RequestBody String id) {
        System.out.println("AppBbsController findUser " + id);
        System.out.println(service.findMyBbs(id).toString());
        return service.findMyBbs(id);
    }


    //좋아요했을때 글의 likecnt 증가
    @RequestMapping(value="/likecntPlus", method = RequestMethod.POST)
    public boolean likecntPlus(@RequestBody int seq){
        System.out.println("AppBbsController likecntPlus " + seq);
        return service.likecntPlus(seq);
    }

    //좋아요 취소했을때 글의 likecnt 감소
    @RequestMapping(value="/likecntMinus", method = RequestMethod.POST)
    public boolean likecntMinus(@RequestBody int seq){
        System.out.println("AppBbsController likecntMinus " + seq);
        return service.likecntMinus(seq);
    }

}
