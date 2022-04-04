package com.proj.eataewon.controller;

import com.proj.eataewon.dto.*;
import com.proj.eataewon.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;


@RestController
public class AppBbsController {


    @Autowired
    BbsService service;

    @RequestMapping(value = "/getBbsListApp", method = {RequestMethod.GET, RequestMethod.POST} )
    public BbsDto getBbsListApp(@RequestBody int seq){
        System.out.println("BbsController getBbsList " + seq);
        System.out.println(service.getBbsListApp(seq).toString());

        return service.getBbsListApp(seq);
    }

    @RequestMapping(value = "/bbswriteApp", method = {RequestMethod.GET, RequestMethod.POST} )
    public int bbswriteApp(@RequestBody BbsDto dto) {
        System.out.println("BbsController bbswrite " + new Date());

        int seq = service.writeBbsApp(dto);
        return seq;
    }

    @RequestMapping(value = "/plustReadcntApp", method=RequestMethod.POST)
    public String plustReadcntApp(@RequestBody int seq) {
        System.out.println(seq);
        System.out.println("BbsController plustReadcntApp " + new Date());
        String res = service.readcountApp(seq);
        System.out.println(res);
        return res;
    }


    @RequestMapping(value = "/bbsdeleteApp", method = {RequestMethod.GET, RequestMethod.POST} )
    public Boolean bbsdeleteApp(@RequestBody int seq) {
        System.out.println("BbsController bbsdeleteApp " + new Date());

        Boolean b = service.deleteBbs(seq);
        System.out.println("삭제결과 불리안값 "+ b);
        return b;
    }

    @RequestMapping(value="/bbsScrap", method = {RequestMethod.GET, RequestMethod.POST})
    public String scrapBbs(ScrapDto dto){
        System.out.println("ScrapDto bbsScrap " + new Date());
        boolean a = service.scrapBbsCnt(dto);
        if(a) {

            boolean b =service.bbsScrap(dto);
            if(b) {
                return "YES";
            }
            return "NO";
        }
        return "DUP";
    }

    @RequestMapping(value="/LikePWriteUp", method=RequestMethod.POST)
    public Boolean LikePWriteUp(@RequestBody String id){
        System.out.println("MemberController LikePWriteUp " + id);

        return service.LikePWriteUp(id);
    }

    @RequestMapping(value="/LikePHeartUp", method=RequestMethod.POST)
    public Boolean LikePHeartUp(@RequestBody String id){
        System.out.println("MemberController LikePHeartUp " + id);

        return service.LikePHeartUp(id);
    }

    @RequestMapping(value="/LikePScrapUp", method=RequestMethod.POST)
    public Boolean LikePScrapUp(@RequestBody String id){
        System.out.println("MemberController LikePScrapUp " + id);

        return service.LikePScrapUp(id);
    }

    @RequestMapping(value="/LikePHeartDown", method=RequestMethod.POST)
    public Boolean LikePHeartDown(@RequestBody String id){
        System.out.println("MemberController LikePHeartUp " + id);

        return service.LikePHeartDown(id);
    }

    @RequestMapping(value="/LikePScrapDown", method=RequestMethod.POST)
    public Boolean LikePScrapDown(@RequestBody String id){
        System.out.println("MemberController LikePScrapUp " + id);

        return service.LikePScrapDown(id);
    }



}
