package com.carlosketer.teafarmerapp;

public class LoanDeal {
    private String id;
    private String title;
    private String location;
    private  String amount;
    private String accountNo;
    private String sacco;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getSacco() {
        return sacco;
    }

    public void setSacco(String sacco) {
        this.sacco = sacco;
    }
    public LoanDeal() {

    }


    public LoanDeal( String title, String location, String amount, String accountNo, String sacco) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.amount = amount;
        this.accountNo = accountNo;
        this.sacco = sacco;
    }
}
