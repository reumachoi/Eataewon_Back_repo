package com.proj.eataewon.controller;

import com.proj.eataewon.dto.*;
import com.proj.eataewon.service.BbsService;
import com.proj.eataewon.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static org.springframework.boot.autoconfigure.mongo.MongoProperties.DEFAULT_URI;

@RestController
public class BbsController {


    @Autowired
    BbsService service;

    @Autowired
    MemberService mservice;

    @RequestMapping(value = "/getBbsList", method = {RequestMethod.GET, RequestMethod.POST} )
    public List<BbsDto> getBbsList(){
        System.out.println("BbsController getBbsList " + new Date());

        List<BbsDto> list = service.getBbsList();
        System.out.println(list.toString() + new Date());
        return list;
    }


    @RequestMapping(value = "/bbswrite", method = {RequestMethod.GET, RequestMethod.POST} )
    public String bbswrite(BbsDto dto) {
        System.out.println("BbsController bbswrite " + new Date());
        System.out.println("BbsController likepointup" + dto.getId()  + new Date());

        //호감도 증가
        boolean a = mservice.likePWriteUp(dto);

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
    public String bbsupdate(BbsDto dto) {
        System.out.println("BbsController bbsupdate " + new Date());

        boolean b = service.updateBbs(dto);
        System.out.println("@@@@@@@@@@dto@@@@@@@@@"+dto.toString());
        if(b) {
            return "OK";
        }
        return "NO";
    }

    @RequestMapping(value = "/bbsdelete", method = {RequestMethod.GET, RequestMethod.POST} )
    public String bbsdelete(int seq, BbsDto dto) {
        System.out.println("BbsController bbsdelete " + new Date());
        System.out.println("BbsController likepointDown " + dto.getId() +new Date());

        //글 삭제시 호감도 감소
        boolean a = mservice.likePWriteDown(dto);


        boolean b = service.deleteBbs(seq);
        if(b) {
            return "OK";
        }
        return "NO";
    }


    @RequestMapping(value="/likeBbs", method = {RequestMethod.GET, RequestMethod.POST})
    public String likeBbs(LikeDto dto, BbsDto bdto){
        System.out.println("LikeDto likeBbs " + dto+ new Date());

        boolean a = service.likebbsCnt(dto); //좋아요 게시판에 중복 없는지 확인
        boolean d = mservice.likePHeartUp(bdto); // 좋아요시 likepoint 증가
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
    public String deleteLike(@RequestParam(value = "json[]") List<String> list, LikeDto dto, BbsDto bdto) {
        System.out.println("BbsController deleteLike " + new Date());

        String answer = "";
        String id = list.get(list.size()-1); //list의 가장 마지막 값이 id이다. 가장 마지막 값을 id 변수로 설정

        for (int i = 0; i < list.size()-1; i++) { //가장 마지막 값인 id값은 빼고 받기 위해 list.size()-1로 범위를 정함.
            dto.setId(id);
            dto.setBbsseq(Integer.parseInt(list.get(i)));

            bdto.setId(id);
            bdto.setSeq(Integer.parseInt(list.get(i)));

            boolean c = service.likecntDown(dto); // 좋아요 값 -1 감소
            boolean d = mservice.likePHeartDown(bdto); // 호감도 -1 감소
            boolean b = service.deleteLike(dto); // deleteLike는 id와 bbsseq값을 확인해야한다.

            if (b) {
                answer = "OK";
            } else
                answer = "NO";
        }
        return answer;
    }


    @RequestMapping(value="/bbsScrap", method = {RequestMethod.GET, RequestMethod.POST})
    public String scrapBbs(ScrapDto dto, BbsDto bdto){
        System.out.println("ScrapDto bbsScrap " + new Date());
        boolean a = service.scrapBbsCnt(dto);
        boolean c = mservice.likePScrapUp(bdto); // 스크랩시 호감도 증가
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

    //나현님 수정하실 예정
  /*  @RequestMapping(value = "/deleteScarp", method = {RequestMethod.GET, RequestMethod.POST} )
    public String deleteScarp(@RequestParam(value = "json[]")List<Integer> list, BbsDto dto) {
        System.out.println("BbsController deleteScarp " + new Date());
        System.out.println("deleteScarp " +list.toString());

        String answer = "";
        for (int n : list) {
            System.out.println(n);
            dto.setSeq(n);
            boolean b = service.deleteScrap(n);
            boolean c = mservice.likePScrapDown(dto); //스크랩 취소시 호감도 -5감소
            if (b) {
                answer = "OK";
            }else
                answer = "NO";
        }
        return answer;

    }
    */

    ////////////////////////////////////////파일포함 페이지 테스트 중////////////////////////////////////////////

    //파일 삽입 페이지 test중
    @RequestMapping(value = "/bbswriteImgup", method = {RequestMethod.GET, RequestMethod.POST} )
    public String bbswriteImgup(BbsFileDto dto) {
        System.out.println("BbsController bbswriteImgup " + new Date());
        System.out.println("BbsController bbswriteImgup" + dto.toString()  + new Date());
        boolean b = service.bbswriteImgup(dto);
        if(b) {
            return "YES";
        }
        return "NO";
    }

    //파일 포함 상세페이지
    @RequestMapping(value = "/bbsFileDetail", method = {RequestMethod.GET, RequestMethod.POST} )
    public BbsFileDto bbsFileDetail(int seq) {
        System.out.println("BbsController BbsFileDto " + new Date());

        service.readcountFile(seq); //조회수 업데이트가 안된다.
        return service.getBbsDetail(seq);
    }

    //글의 총 개수
    @RequestMapping(value = "/getBbsFileCount", method = {RequestMethod.GET, RequestMethod.POST} )
    public int getBbsFileCount(BbsParam param) {
        System.out.println("BbsController getBbsFileCount " + new Date());
        return service.getBbsFileCount(param);
    }


    //파일 포함 리스트
    @RequestMapping(value = "/getBbsListFileSearchPage", method = {RequestMethod.GET, RequestMethod.POST} )
    public List<BbsFileDto> getBbsListFileSearchPage(BbsParam param){
        System.out.println("BbsController getBbsListFileSearchPage " + new Date());

        // 페이지 설정
        int sn = param.getPage();	// 0 1 2 3 ~
        int start = sn * 10 + 1;	// 1	11
        int end = (sn + 1) * 10;	// 10	20

        param.setStart(start);
        param.setEnd(end);

        return service.getBbsListFileSearchPage(param);
    }

    //파일수정
    @RequestMapping(value = "/updateBbsFile", method = {RequestMethod.GET, RequestMethod.POST} )
    public String bbsupdate(BbsFileDto dto) {
        System.out.println("BbsController updateBbsFile " + new Date());

        boolean b = service.updateBbsFile(dto);
        System.out.println("@@@@@@@@@@dto@@@@@@@@@"+dto.toString());
        if(b) {
            return "OK";
        }
        return "NO";
    }

    //글삭제
    @RequestMapping(value = "/deleteBbsFile", method = {RequestMethod.GET, RequestMethod.POST} )
    public String deleteBbsFile(int seq, BbsFileDto dto) {
        System.out.println("BbsController deleteBbsFile " + new Date());
        //System.out.println("BbsController likepointDown " + dto.getId() +new Date());

        //글 삭제시 호감도 감소
       // boolean a = service.likepointdown(dto);


        boolean b = service.deleteBbsFile(seq);
        if(b) {
            return "OK";
        }
        return "NO";
    }

    //좋아요
    @RequestMapping(value="/likeBbsFile", method = {RequestMethod.GET, RequestMethod.POST})
    public String likeBbsFile(LikeDto dto, BbsFileDto fdto){
        System.out.println("LikeDto likeBbs " + dto.toString()+ new Date());

        boolean a = service.likebbsfileCnt(dto); //좋아요 게시판에 중복 없는지 확인
        boolean d = service.lpplusfilepoint(fdto); // 좋아요시 likepoint 증가
        if(a) {

            boolean c = service.likecntfileUpdate(dto);
            System.out.println("seq"+dto.getSeq());
            boolean b = service.likeBbsFile(dto);
            if(b&&c) {
                return "YES";
            }
            return "NO";
        }
        return "DUP";

    }

    //좋아요 목록
    @RequestMapping(value = "/likeBbsListFile", method = {RequestMethod.GET, RequestMethod.POST} )
    public List<BbsFileDto> likeBbsListFile(BbsFileDto dto){
        System.out.println("BbsController likeBbsListFile " + dto.toString() + new Date());

        List<BbsFileDto> list = service.likeBbsListFile(dto);
        System.out.println("BbsController likeBbsListFile output " + list.toString());
        return list;
    }


    //좋아요 취소
    @RequestMapping(value = "/deleteLikefile", method = {RequestMethod.GET, RequestMethod.POST} )
    public String deleteLikefile(@RequestParam(value = "json[]") List<String> list, LikeDto dto, BbsFileDto fdto) {
        System.out.println("BbsController deleteLikefile " + new Date());

        String answer = "";
        String id = list.get(list.size()-1); //list의 가장 마지막 값이 id이다. 가장 마지막 값을 id 변수로 설정

        for (int i = 0; i < list.size()-1; i++) { //가장 마지막 값인 id값은 빼고 받기 위해 list.size()-1로 범위를 정함.
            dto.setId(id);
            dto.setBbsseq(Integer.parseInt(list.get(i)));

            fdto.setId(id);
            fdto.setSeq(Integer.parseInt(list.get(i)));

            boolean c = service.likecntDownfile(dto); // 좋아요 값 -1 감소
            boolean d = service.lpminuspointfile(fdto); // 호감도 -1 감소
            boolean b = service.deleteLikefile(dto); // deleteLike는 id와 bbsseq값을 확인해야한다.

            if (b) {
                answer = "OK";
            } else
                answer = "NO";
        }
        return answer;
    }


    //스크랩
    @RequestMapping(value="/bbsScrapfile", method = {RequestMethod.GET, RequestMethod.POST})
    public String bbsScrapfile(ScrapDto dto, BbsFileDto bdto){
        System.out.println("ScrapDto bbsScrapfile " + new Date());
        boolean a = service.scrapBbsCntfile(dto);
        boolean c = service.scrpointupfile(bdto); // 스크랩시 호감도 증가
        if(a) {

            boolean b =service.bbsScrapfile(dto);
            if(b) {
                return "YES";
            }
            return "NO";
        }
        return "DUP";

    }


    //스크랩 리스트
    @RequestMapping(value = "/scrapBbsListfile", method = {RequestMethod.GET, RequestMethod.POST} )
    public List<BbsFileDto> scrapBbsListfile(BbsFileDto dto){
        System.out.println("BbsController scrapBbsListfile " + dto + new Date());

        List<BbsFileDto> list = service.scrapBbsListfile(dto);
        System.out.println("BbsController scrapBbsListfile output " + list.toString());
        return list;
    }


    @RequestMapping(value = "/deleteScrapfile", method = {RequestMethod.GET, RequestMethod.POST} )
    public String deleteScarpfile(@RequestParam(value = "json[]")List<Integer> list, BbsFileDto dto) {
        System.out.println("BbsController deleteScarpfile " + new Date());
        System.out.println("deleteScarpfile " +list.toString());

        String answer = "";
        for (int n : list) {
            System.out.println(n);
            dto.setSeq(n);
            boolean b = service.deleteScrapfile(dto);
            boolean c = service.scrpointminusfile(dto); //스크랩 취소시 호감도 -5감소
            if (b) {
                answer = "OK";
            }else
                answer = "NO";
        }
        return answer;

    }




}
