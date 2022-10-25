package com.carlosketer.teafarmerapp;

public class ToolsDeal {
    private String applicantName;
    private String sacco;
    private String phone;
    private String county;
    private String area;
    private String bagsNo;
    private String bagsQuantity;
    private String gumbootSize;
    private String gumbootPairs;
    private String id;

    public ToolsDeal(String applicantName, String sacco, String phone, String county, String area,
                     String bagsNo, String bagsQuantity, String gumbootSize, String gumbootPairs, String id) {
        this.applicantName = applicantName;
        this.sacco = sacco;
        this.phone = phone;
        this.county = county;
        this.area = area;
        this.bagsNo = bagsNo;
        this.bagsQuantity = bagsQuantity;
        this.gumbootSize = gumbootSize;
        this.gumbootPairs = gumbootPairs;
        this.id = id;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getSacco() {
        return sacco;
    }

    public void setSacco(String sacco) {
        this.sacco = sacco;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBagsNo() {
        return bagsNo;
    }

    public void setBagsNo(String bagsNo) {
        this.bagsNo = bagsNo;
    }

    public String getBagsQuantity() {
        return bagsQuantity;
    }

    public void setBagsQuantity(String bagsQuantity) {
        this.bagsQuantity = bagsQuantity;
    }

    public String getGumbootSize() {
        return gumbootSize;
    }

    public void setGumbootSize(String gumbootSize) {
        this.gumbootSize = gumbootSize;
    }

    public String getGumbootPairs() {
        return gumbootPairs;
    }

    public void setGumbootPairs(String gumbootPairs) {
        this.gumbootPairs = gumbootPairs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ToolsDeal{" +
                "applicantName='" + applicantName + '\'' +
                ", sacco='" + sacco + '\'' +
                ", phone='" + phone + '\'' +
                ", county='" + county + '\'' +
                ", area='" + area + '\'' +
                ", bagsNo='" + bagsNo + '\'' +
                ", bagsQuantity='" + bagsQuantity + '\'' +
                ", gumbootSize='" + gumbootSize + '\'' +
                ", gumbootPairs='" + gumbootPairs + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
