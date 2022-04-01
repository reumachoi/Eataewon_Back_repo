package com.proj.eataewon.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;


import com.mysql.cj.log.Log;
import com.proj.eataewon.dto.*;
import com.proj.eataewon.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.swing.filechooser.FileSystemView;


import javax.servlet.http.HttpServletRequest;

import static org.springframework.boot.autoconfigure.mongo.MongoProperties.DEFAULT_URI;

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
    public String bbsWrite(BbsDto dto) {
        System.out.println("BbsController bbswrite " + new Date());

        boolean b = service.writeBbs(dto);
        if(b) {
            return "YES";
        }
        return "NO";
    }


    @PostMapping(DEFAULT_URI + "/multi")
    public String uploadMulti(@RequestParam("files") List<MultipartFile> files) throws Exception {
        String rootPath = FileSystemView.getFileSystemView().getHomeDirectory().toString();
        String basePath = rootPath + "/" + "multi";
        // 파일 업로드(여러개) 처리 부분
        for(MultipartFile file : files) {
            String originalName = file.getOriginalFilename();
            String filePath = basePath + "/" + originalName;
            File dest = new File(filePath);
            file.transferTo(dest);
        }
        return "uploaded";
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
    public Boolean bbsupdate(BbsDto dto) {
        System.out.println("BbsController bbsupdate " + new Date());

        boolean b = service.updateBbs(dto);
        System.out.println("@@@@@@@@@@dto@@@@@@@@@"+dto.toString());
        if(b) {
            return "OK";
        }
        return "NO";
    }

    @RequestMapping(value = "/bbsdelete", method = {RequestMethod.GET, RequestMethod.POST} )
    public Boolean bbsdelete(int seq) {
        System.out.println("BbsController bbsdelete " + new Date());

        return service.deleteBbs(seq);
    }


    @RequestMapping(value="/likeBbs", method = {RequestMethod.GET, RequestMethod.POST})
    public String likeBbs(LikeDto dto){
        System.out.println("LikeDto likeBbs " + dto+ new Date());
        boolean a = service.likebbsCnt(dto);
        if(a) {

            boolean c = service.likecntUpdate(dto);
            System.out.println("seq"+dto.getSeq());
            boolean b = service.likeBbs(dto);

            if(b&&c) {
                return "YES";
            }
            return "NO";
        }
        return "DUP";

    }

    @RequestMapping(value = "/likeBbsList", method = {RequestMethod.GET, RequestMethod.POST} )
    public List<BbsDto> likeBbsList(BbsDto dto){
        System.out.println("BbsController likeBbsList " + dto.toString() + new Date());

        List<BbsDto> list = service.likeBbsList(dto);
        System.out.println("BbsController likeBbsList output " + list.toString());
        return list;
    }



    @RequestMapping(value = "/deleteLike", method = {RequestMethod.GET, RequestMethod.POST} )
    public String deleteLike(@RequestParam(value = "json[]") List<String> list, LikeDto dto) {
        System.out.println("BbsController deleteLike " + new Date());

        String answer = "";
        String id = list.get(list.size()-1); //list의 가장 마지막 값이 id이다. 가장 마지막 값을 id 변수로 설정

        for (int i = 0; i < list.size()-1; i++) { //가장 마지막 값인 id값은 빼고 받기 위해 list.size()-1로 범위를 정함.
            dto.setId(id);
            dto.setBbsseq(Integer.parseInt(list.get(i)));

            boolean c = service.likecntDown(dto); // 좋아요 값 -1 감소
            boolean b = service.deleteLike(dto); // deleteLike는 id와 bbsseq값을 확인해야한다.

            if (b) {
                answer = "OK";
            } else
                answer = "NO";
        }
        return answer;
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


    @RequestMapping(value = "/scrapBbsList", method = {RequestMethod.GET, RequestMethod.POST} )
    public List<BbsDto> scrapBbsList(BbsDto dto){
        System.out.println("BbsController scrapBbsList " + dto + new Date());

        List<BbsDto> list = service.scrapBbsList(dto);
        System.out.println("BbsController scrapBbsList output " + list.toString());
        return list;
    }


    @RequestMapping(value = "/deleteScarp", method = {RequestMethod.GET, RequestMethod.POST} )
    public String deleteScarp(@RequestParam(value = "json[]")List<Integer> list) {
        System.out.println("BbsController deleteScarp " + new Date());
        System.out.println("deleteScarp " +list.toString());
        String answer = "";
        for (int n : list) {
            System.out.println(n);
            boolean b = service.deleteScarp(n);
            if (b) {
                answer = "OK";
            }else
                answer = "NO";
        }
        return answer;

    }


    @RequestMapping(value="/bbswriteImgup", method = {RequestMethod.GET, RequestMethod.POST})
    public String writeAction(
            HttpServletRequest req,
            @RequestParam("id") String id,
            @RequestParam("title")String title,
//            @RequestParam("file") MultipartFile file,
            @RequestParam("content") String contents,
            @RequestParam("hashtag") String hashtag,
//            @RequestParam("wdate") String wdate,
            @RequestParam("shopname") String shopname,
            @RequestParam("latitude") double latitude,
            @RequestParam("longtitude") double longtitude,
            @RequestParam("address") String address

            ) throws IllegalStateException, IOException {
        String PATH = req.getSession().getServletContext().getRealPath("/") + "resources/";
        System.out.println("PATH " +PATH.toString());
/*
        System.out.println("file " +file.getOriginalFilename().toString());

        if (!file.getOriginalFilename().isEmpty()) {
            file.transferTo(new File(PATH + file.getOriginalFilename()));
        }*/
//        service.writeBbsfile(new BbsFileDto(id,title,file.getOriginalFilename(),contents,hashtag,wdate,shopname,latitude,longtitude,address,0,0));
        service.bbswriteImgup(new BbsFileDto(id,title,"a.PNG",contents,hashtag,"",shopname,latitude,longtitude,address,0,0));

        return "YES";
    }



}
