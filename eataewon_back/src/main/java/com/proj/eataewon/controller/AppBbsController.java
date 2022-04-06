package com.proj.eataewon.controller;

import com.proj.eataewon.dto.*;
import com.proj.eataewon.service.AppBbsService;
import com.proj.eataewon.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class AppBbsController {

    @Autowired
    AppBbsService service;

    @Autowired
    BbsService bservice;

    @RequestMapping(value = "/getUpperBbsListApp", method = {RequestMethod.GET, RequestMethod.POST})
    public ArrayList<BbsDto> getUpperBbsListApp() {
        System.out.println("BbsController getBbsList ");

        ArrayList<BbsDto> list = service.getUpperBbsListApp();
        return list;
    }

    @RequestMapping(value = "/getLowerBbsListApp", method = {RequestMethod.GET, RequestMethod.POST})
    public ArrayList<BbsDto> getLowerBbsListApp() {
        System.out.println("BbsController getBbsList ");

        ArrayList<BbsDto> list = service.getLowerBbsListApp();
        return list;
    }

    @RequestMapping(value = "/getBbsListApp", method =  {RequestMethod.GET, RequestMethod.POST})
    public ArrayList<BbsDto> getBbsListApp() {
        System.out.println("BbsController getBbsList ");

        ArrayList<BbsDto> list = service.getBbsListApp();
        return list;
    }

    @RequestMapping(value = "/bbswriteApp", method = {RequestMethod.GET, RequestMethod.POST})
    public int bbswriteApp(@RequestBody BbsDto dto) {
        System.out.println("BbsController bbswrite " + new Date());

        int seq = service.writeBbsApp(dto);
        if(seq>0){

        }
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
}