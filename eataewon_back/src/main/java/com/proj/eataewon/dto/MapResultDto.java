package com.proj.eataewon.dto;

public class MapResultDto {

    private String shopname;
    private String address;
    private double latitude;
    private double longtitude;
    private String shopphnum;
    private String shopurl;

    public MapResultDto(){

    }

    public MapResultDto(String shopname,
                        String address, double latitude, double longtitude,
                        String shopphnum, String shopurl) {

        this.shopname = shopname;
        this.address = address;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.shopphnum = shopphnum;
        this.shopurl = shopurl;
    }

    public MapResultDto(String shopname,
                        String address,
                        String shopphnum, String shopurl) {
        super();
        this.shopname = shopname;
        this.address = address;
        this.shopphnum = shopphnum;
        this.shopurl = shopurl;
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
        return "MapResultDto{" +
                ", shopname='" + shopname + '\'' +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longtitude=" + longtitude +
                ", shopphnum='" + shopphnum + '\'' +
                ", shopurl='" + shopurl + '\'' +
                '}';
    }
}
