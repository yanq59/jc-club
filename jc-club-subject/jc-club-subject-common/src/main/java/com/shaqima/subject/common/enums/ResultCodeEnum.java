package com.shaqima.subject.common.enums;

import lombok.Getter;

/**
 * @Description : 状态枚举
 * @Author : wang.yanqi
 * @Date: 2024/9/1 20:29
 */
@Getter
public enum ResultCodeEnum {

    // 成功
    SUCCESS(200, "成功"),
    // 失败
    FAIL(500, "失败");

    // 状态码
    public int code;

    // 描述
    public String desc;

    // 构造方法
    ResultCodeEnum(int code, String desc) {
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
