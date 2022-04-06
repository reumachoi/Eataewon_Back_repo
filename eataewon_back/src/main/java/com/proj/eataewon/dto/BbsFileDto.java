package com.proj.eataewon.dto;

public class BbsFileDto {

    private String id;
    private int seq;
    private String title;
    private String content;
    private String filename;
    private String filepath;
    private String nickname;

    private String hashtag;
    private String wdate;
    private String shopname;
    private String address;
    private double latitude;
    private double longitude;
    private int readcnt;
    private int likecnt;

    private String shopphnum;
    private String shopurl;

    public BbsFileDto(){

    }

    public BbsFileDto(String id, int seq, String nickname, String title, String content,
                      String filename, String filepath, String hashtag,
                      String wdate, String shopname,
                      String address, double latitude, double longitude,
                      int readcnt, int likecnt, String shopphnum,String shopurl) {
        this.id = id;
        this.seq = seq;
        this.nickname =nickname;
        this.title = title;
        this.content = content;
        this.filename = filename;
        this.filepath = filepath;
        this.hashtag = hashtag;
        this.wdate = wdate;
        this.shopname = shopname;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.readcnt = readcnt;
        this.likecnt = likecnt;
        this.shopphnum = shopphnum;
        this.shopurl = shopurl;
    }

    public BbsFileDto(String id, String title, String content) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
    }



    public BbsFileDto(String id, String title, String nickname, String content, String filename, String filepath, String hashtag, String shopname,
                      String address, double latitude, double longitude, String shopphnum, String shopurl) {
        super();
        this.id = id;
        this.title = title;
        this.nickname = nickname;
        this.content = content;
        this.filename = filename;
        this.filepath = filepath;
        this.hashtag = hashtag;
        this.shopname = shopname;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.shopphnum = shopphnum;
        this.shopurl = shopurl;


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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longtitude) {
        this.longitude = longitude;
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

    public String getnickname() {
        return nickname;
    }

    public void setnickname(String nickname) {
        this.nickname = nickname;
    }

    public String getShopphnum() {
        return shopphnum;
    }

    public void setShopphnum(String shopphnum) {
        this.shopphnum = shopphnum;
    }

    public String getShopurl() {
        return shopurl;
    }

    public void setShopurl(String shopurl) {
        this.shopurl = shopurl;
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
                ", nickname='" + nickname + '\'' +
                ", hashtag='" + hashtag + '\'' +
                ", wdate='" + wdate + '\'' +
                ", shopname='" + shopname + '\'' +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", readcnt=" + readcnt +
                ", likecnt=" + likecnt +
                ", shopphnum='" + shopphnum + '\'' +
                ", shopurl='" + shopurl + '\'' +
                '}';
    }
}
