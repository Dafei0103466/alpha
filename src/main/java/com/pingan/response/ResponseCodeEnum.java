package com.pingan.response;
/*
 *created by dafei on 2020/4/6
 */


public enum ResponseCodeEnum {
    SUCCESS("业务处理成功","0000"),FAIL("业务处理失败","0001");

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String code;


    // 构造方法
    private ResponseCodeEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
