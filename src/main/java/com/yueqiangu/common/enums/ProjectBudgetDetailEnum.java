package com.yueqiangu.common.enums;

/**
 * @author yanghc
 */

public enum ProjectBudgetDetailEnum {

    DETAIL_TYPE_TWO("项目构成","1"),
    DETAIL_TYPE_THREE("项目明细","2");

    private String code;
    private String value;

    ProjectBudgetDetailEnum(String code, String value) {
        this.value = value;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static String findValue(String code) {
        ProjectBudgetDetailEnum[] list = values();
        for (ProjectBudgetDetailEnum projectBudgetDetailEnum : list) {
            if (projectBudgetDetailEnum.getCode().equals(code)) {
                return projectBudgetDetailEnum.getValue();
            }
        }
        return null;
    }
}
