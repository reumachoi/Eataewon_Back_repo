package com.proj.eataewon.dto;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UploadResultDto {

    private String fileName;

    private String uuid;

    private String folderPath;

    public String getImageURL(){
        try {
            return URLEncoder.encode(folderPath+"/" +uuid + fileName,"UTF-8");

        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return "";
    }

    public UploadResultDto(String fileName, String uuid, String folderPath) {
        super();
        this.fileName = fileName;
        this.uuid = uuid;
        this.folderPath = folderPath;
    }

    public UploadResultDto() {
        // TODO Auto-generated constructor stub
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    @Override
    public String toString() {
        return "UploadResultDto [fileName=" + fileName + ", uuid=" + uuid + ", folderPath=" + folderPath + "]";
    }


}