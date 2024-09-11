package com.shaqima.subject.common.enums;

/**
 * @Description: 题目类型枚举
 * 1单选 2多选 3判断 4简答
 * @Author: wang.yanqi
 * @CreateTime: 2024-09-11
 */

public enum SubjectInfoTypeEnum {

    RADIO(1, "单选"),
    MULTIPLE(2, "多选"),
    JUDGE(3, "判断"),
    BRIEF(4, "简答");

    private int code;
    private String desc;

    SubjectInfoTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    // 根据状态码获取枚举值
    public static SubjectInfoTypeEnum getByCode(int codeVal){
        for(SubjectInfoTypeEnum resultCodeEnum : SubjectInfoTypeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }


}
