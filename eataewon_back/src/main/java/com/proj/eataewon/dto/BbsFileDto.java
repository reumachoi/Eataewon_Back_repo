package com.proj.eataewon.dto;

public class BbsFileDto {

    private String id;
    private int seq;
    private String title;
    private String content;
    private String filename;
    private String filepath;
    private String hashtag;
    private String wdate;
    private String shopname;
    private String address;
    private double latitude;
    private double longtitude;
    private int readcnt;
    private int likecnt;

    public BbsFileDto(){

    }

    public BbsFileDto(String id, int seq, String title, String content, String filename, String filepath, String hashtag, String wdate, String shopname, String address, double latitude, double longtitude, int readcnt, int likecnt) {
        this.id = id;
        this.seq = seq;
        this.title = title;
        this.content = content;
        this.filename = filename;
        this.filepath = filepath;
        this.hashtag = hashtag;
        this.wdate = wdate;
        this.shopname = shopname;
        this.address = address;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.readcnt = readcnt;
        this.likecnt = likecnt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public String getWdate() {
        return wdate;
    }

    public void setWdate(String wdate) {
        this.wdate = wdate;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public int getReadcnt() {
        return readcnt;
    }

    public void setReadcnt(int readcnt) {
        this.readcnt = readcnt;
    }

    public int getLikecnt() {
        return likecnt;
    }

    public void setLikecnt(int likecnt) {
        this.likecnt = likecnt;
    }

    @Override
    public String toString() {
        return "BbsFileDto{" +
                "id='" + id + '\'' +
                ", seq=" + seq +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", filename='" + filename + '\'' +
                ", filepath='" + filepath + '\'' +
                ", hashtag='" + hashtag + '\'' +
                ", wdate='" + wdate + '\'' +
                ", shopname='" + shopname + '\'' +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longtitude=" + longtitude +
                ", readcnt=" + readcnt +
                ", likecnt=" + likecnt +
                '}';
    }
}
