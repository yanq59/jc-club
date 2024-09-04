package com.shaqima.subject.common.enums;

import lombok.Getter;

/**
 * @Description: 删除状态枚举
 * @Author: wang.yanqi
 * @CreateTime: 2024-09-04
 */

@Getter
public enum IsDeletedFlagEnum {

    DELETED(1, "已删除"),
    NO_DELETED(0, "未删除");

    private Integer code;
    private String desc;

    IsDeletedFlagEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    // 根据状态码获取枚举值
    public static IsDeletedFlagEnum getByCode(int codeVal){
        for(IsDeletedFlagEnum resultCodeEnum : IsDeletedFlagEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}
