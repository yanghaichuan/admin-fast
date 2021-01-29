package com.yueqiangu.common.enums;

public enum ProjectStatusEnum {
    INFO("1","核定"),
    APPLY("2","申请"),
    DEPT_APPROVAL("3","部门审核"),
    FINANCE_APPROVAL("4","财务审核"),
    NO("5","不通过");
    private String code;
    private String value;

    ProjectStatusEnum(String code, String value) {
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
