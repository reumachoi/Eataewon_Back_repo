package com.proj.eataewon.controller;


import java.util.Date;
import java.util.List;

import com.proj.eataewon.dto.BbsDto;
import com.proj.eataewon.dto.BbsParam;
import com.proj.eataewon.dto.LikeDto;
import com.proj.eataewon.dto.ScrapDto;
import com.proj.eataewon.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BbsController {


    @Autowired
    BbsService service;

    @RequestMapping(value = "/getBbsList", method = {RequestMethod.GET, RequestMethod.POST} )
    public List<BbsDto> getBbsList(){
        System.out.println("BbsController getBbsList " + new Date());

        List<BbsDto> list = service.getBbsList();
        return list;
    }

    @RequestMapping(value = "/bbswrite", method = {RequestMethod.GET, RequestMethod.POST} )
    public String bbswrite(BbsDto dto) {
        System.out.println("BbsController bbswrite " + new Date());

        boolean b = service.writeBbs(dto);
        if(b) {
            return "YES";
        }
        return "NO";
    }


    @RequestMapping(value = "/bbsdetail", method = {RequestMethod.GET, RequestMethod.POST} )
    public BbsDto bbsdetail(int seq) {
        System.out.println("BbsController BbsDto " + new Date());

        service.readcount(seq);
        return service.getBbs(seq);
    }

    @RequestMapping(value = "/getBbsListSearch", method = {RequestMethod.GET, RequestMethod.POST} )
    public List<BbsDto> getBbsListSearch(BbsParam param){
        System.out.println("BbsController getBbsListSearch " + new Date());

        return service.getBbsListSearch(param);
    }

    @RequestMapping(value = "/getBbsListSearchPage", method = {RequestMethod.GET, RequestMethod.POST} )
    public List<BbsDto> getBbsListSearchPage(BbsParam param){
        System.out.println("BbsController getBbsListSearchPage " + new Date());

        // 페이지 설정
        int sn = param.getPage();	// 0 1 2 3 ~
        int start = sn * 10 + 1;	// 1	11
        int end = (sn + 1) * 10;	// 10	20

        param.setStart(start);
        param.setEnd(end);

        return service.getBbsListSearchPage(param);
    }

    @RequestMapping(value = "/getBbsCount", method = {RequestMethod.GET, RequestMethod.POST} )
    public int getBbsCount(BbsParam param) {
        System.out.println("BbsController getBbsCount " + new Date());
        return service.getBbsCount(param);
    }

    @RequestMapping(value = "/bbsupdate", method = {RequestMethod.GET, RequestMethod.POST} )
    public String bbsupdate(BbsDto dto) {
        System.out.println("BbsController bbsupdate " + new Date());

        boolean b = service.updateBbs(dto);
        if(b) {
            return "OK";
        }
        return "NO";
    }

    @RequestMapping(value = "/bbsdelete", method = {RequestMethod.GET, RequestMethod.POST} )
    public String bbsdelete(int seq) {
        System.out.println("BbsController bbsdelete " + new Date());

        boolean b = service.deleteBbs(seq);
        if(b) {
            return "OK";
        }
        return "NO";
    }

    @RequestMapping(value="/bbsScrap", method = {RequestMethod.GET, RequestMethod.POST})
    public String scrapBbs(ScrapDto dto){
        System.out.println("ScrapDto bbsScrap " + new Date());

        System.out.println(dto.toString());

        boolean b =service.bbsScrap(dto);
        if(b) {
            return "YES";
        }
        return "NO";

    }


    @RequestMapping(value="/likeBbs", method = {RequestMethod.GET, RequestMethod.POST})
    public String likeBbs(LikeDto dto){
        System.out.println("LikeDto likeBbs " + dto+ new Date());
         boolean a = service.likebbsCnt(dto);
        if(a) {
            boolean b =service.likeBbs(dto);
            if(b) {
                return "YES";
            }
            return "NO";
        }
        return "DUP";
//        System.out.println(dto.toString());



    }

    @RequestMapping(value = "/scrapBbsList", method = {RequestMethod.GET, RequestMethod.POST} )
    public List<BbsDto> scrapBbsList(String id){
        System.out.println("BbsController scrapBbsList " + id + new Date());

        List<BbsDto> list = service.scrapBbsList(id);
        System.out.println("BbsController scrapBbsList output " + list);
        return list;
    }

    @RequestMapping(value = "/likeBbsList", method = {RequestMethod.GET, RequestMethod.POST} )
    public List<BbsDto> likeBbsList(String id){
        System.out.println("BbsController likeBbsList " + id + new Date());

        List<BbsDto> list = service.likeBbsList(id);
        System.out.println("BbsController likeBbsList output " + list.toString());
        return list;
    }

    @RequestMapping(value = "/deleteScarp", method = {RequestMethod.GET, RequestMethod.POST} )
    public String deleteScarp(int seq) {
        System.out.println("BbsController deleteScarp " + new Date());

        boolean b = service.deleteScarp(seq);
        if(b) {
            return "OK";
        }
        return "NO";
    }





}
