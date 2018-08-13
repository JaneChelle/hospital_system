package org.wlgzs.hospitalmanage.util;

public enum ResultCode {
    SUCCESS(0, "请求成功"),
    WARN(-1, "网络异常，请稍后重试"),
    FAIL(-1,"操作失败"),
    DEFEATEDEMAIL(-1,"没有此邮箱"),
    DEFEATEDB(0,"此账号已被绑定"),
    USERNAME(0,"该昵称不存在"),
    ADMIN(1,"管理员"),
    NOMONEY(-1,"账户余额不足");
    public int code;
    private String msg;

    ResultCode(int code, String msg) {
     this.code = code;
     this.msg = msg;
    }
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
