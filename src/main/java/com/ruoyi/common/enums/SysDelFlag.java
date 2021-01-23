package com.ruoyi.common.enums;

public enum SysDelFlag {
    NORMAL("0","正常"),
    DEL("1","删除");

    private String code;
    private String value;

    SysDelFlag(String code, String value) {
        this.value = value;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
