package com.hongwei.demo.model;

public class PayResMsg {
    private PayCryticCodes code;
    private String msg;

    public PayResMsg() {
    }

    public PayResMsg(PayCryticCodes code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public PayCryticCodes getCode() {

        return code;
    }

    public void setCode(PayCryticCodes code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
