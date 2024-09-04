package com.shaqima.subject.common.enums;

/**
 * @Description: 分类类型枚举
 * @Author: wang.yanqi
 * @CreateTime: 2024-09-04
 */

public enum CategoryTypeEnum {

    PRIMARY(1, "岗位大类"),
    SECOND(2, "二级分类");

    private int code;
    private String desc;

    CategoryTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    // 根据状态码获取枚举值
    public static ResultCodeEnum getByCode(int codeVal) {
        for ( ResultCodeEnum resultCodeEnum : ResultCodeEnum.values()) {
            if (resultCodeEnum.code == codeVal)
                return resultCodeEnum;
        }
        return null;
    }
}
