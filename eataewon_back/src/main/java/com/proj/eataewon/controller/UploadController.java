package com.proj.eataewon.controller;


        import com.proj.eataewon.dto.MemberDto;
        import com.proj.eataewon.dto.UploadRegitDto;
        import com.proj.eataewon.dto.UploadResultDto;
        import com.proj.eataewon.service.MemberService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;
        import org.springframework.web.multipart.MultipartFile;

        import javax.servlet.http.HttpServletRequest;
        import java.io.*;
        import java.net.URLDecoder;
        import java.nio.file.Path;
        import java.nio.file.Paths;
        import java.time.LocalDate;
        import java.time.format.DateTimeFormatter;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;
        import java.util.UUID;

@RestController
public class UploadController {

    @Autowired
    MemberService service;

    @Value("${com.example.upload.path}") // application.properties의 변수
    private String uploadPath;

    @PostMapping("/removeFile")
    public ResponseEntity<Boolean> removeFile(String fileName){
        System.out.println("removeFile::::"+fileName);
        String srcFileName = null;

        try {
            srcFileName = URLDecoder.decode(fileName,"UTF-8");
            File file = new File(uploadPath + File.separator + srcFileName);

            boolean result = file.delete();

            return new ResponseEntity<>(result,HttpStatus.OK);

        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
            return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/uploadAjax")
    public ResponseEntity<List<UploadResultDto>> uploadFile(MultipartFile[] uploadFiles){
        System.out.println("uploadFiles!!!"+uploadFiles);

        List<UploadResultDto> resultDTOList = new ArrayList<>();

        if (uploadFiles == null) {
            return new ResponseEntity<>(resultDTOList, HttpStatus.OK);
        }

        for (MultipartFile uploadFile : uploadFiles) {

            System.out.println("getOriginalFilename:" + uploadFile.getOriginalFilename());

            // 이미지 파일만 업로드 가능
            if(uploadFile.getContentType().startsWith("image") == false){
                // 이미지가 아닌경우 403 Forbidden 반환
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

            // 실제 파일 이름 IE나 Edge는 전체 경로가 들어오므로
            String originalName = uploadFile.getOriginalFilename();

            String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1);

            // 날짜 폴더 생성
            String folderPath = makeFolder();

            //UUID
            String uuid = UUID.randomUUID().toString();

            //저장할 파일 이름
            String saveName = uploadPath + File.separator + folderPath + File.separator + uuid + fileName;
            System.out.println("//////"+saveName);

            Path savePath = Paths.get(saveName);

            try {
                uploadFile.transferTo(savePath);// 실제 이미지 저장
                resultDTOList.add(new UploadResultDto(fileName,uuid,folderPath));
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return new ResponseEntity<>(resultDTOList, HttpStatus.OK);
    }


    @PostMapping("/uploadAjaxRegi")
    public String uploadFileRegi(MemberDto dto, @RequestParam("uploadFiles")MultipartFile uploadFileRegis, HttpServletRequest req) {
        System.out.println("uploadFileRegis!!!");
        System.out.println(dto.toString());

        String filename = uploadFileRegis.getOriginalFilename();

        String path = "C:/eataewon_Front/eataewon_Front/WebContent/image/upload";

        //UUID
        String uuid = UUID.randomUUID().toString();
        String filePath = path + "/" + uuid;

        System.out.println("filePath:" + filePath);

        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
            bos.write(uploadFileRegis.getBytes());
            bos.close();
        }catch (Exception e){
            e.printStackTrace();
            return "file upload fail";
        }

        dto.setProfilpic(filePath);
        boolean b = service.addmember(dto);
        if(b) {
            return "YES";
        }
        return "NO";
    }


    @PostMapping("/updateAjaxMem")
    public String updateAjaxMem(MemberDto dto, @RequestParam("uploadFiles")MultipartFile uploadFileRegis, HttpServletRequest req) {
        System.out.println("updateAjaxMem!!!");
        System.out.println(dto.toString());

        //id 통해서 DB로부터 기존 파일 경로 호출
       String existProfile = service.profilePath(dto.getId());

        //호출된 파일경로를 dto에 저장. 읽히지 않은 파일 명과 파일 경로 삽입.
        if(dto.getProfilpic().equals("")){
            dto.setProfilpic(existProfile);
        }


        String filename = uploadFileRegis.getOriginalFilename();

        String path = "C:/eataewon_Front/eataewon_Front/WebContent/image/upload";

        //UUID
        String uuid = UUID.randomUUID().toString();
        String filePath = path + "/" + uuid;

        System.out.println("filePath:" + filePath);

        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
            bos.write(uploadFileRegis.getBytes());
            bos.close();
        }catch (Exception e){
            e.printStackTrace();
            return "file upload fail";
        }

        System.out.println("MemberDto dto updateMem " + new Date());

        dto.setProfilpic(filePath);
        boolean b = service.updateMem(dto);
        System.out.println("@@@@@@@@@@dto@@@@@@@@@"+dto.toString());
        if(b) {
            return "OK";
        }
        return "NO";
    }






    private String makeFolder() {

        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        String folderPath = str.replace("/", File.separator);

        // make folder
        File uploadPatheFolder = new File(uploadPath,folderPath);

        if(uploadPatheFolder.exists() == false){
            uploadPatheFolder.mkdirs();
        }

        return folderPath;
    }



}