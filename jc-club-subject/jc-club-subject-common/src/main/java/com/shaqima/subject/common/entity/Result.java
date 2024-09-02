package com.shaqima.subject.common.entity;

import com.shaqima.subject.common.enums.ResultCodeEnum;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description : 写 返回给前端的内容
 * @Author : wang.yanqi
 * @Date: 2024/9/1 17:20
 */
@Data
@Slf4j
public class Result<T> {

    private Boolean success;

    private Integer code;

    private String message;

    private T data;

    public static Result ok(){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getDesc());
        return result;
    }

    public static <T> Result ok(T data){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getDesc());
        result.setData(data);
        return result;
    }

    public static Result fail(){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setMessage(ResultCodeEnum.FAIL.getDesc());
        return result;
    }

    public static <T> Result fail(T data){
        System.out.println("fail method called with data: " + data);
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setMessage(ResultCodeEnum.FAIL.getDesc());
        result.setData(data);
        log.debug("Result.fail called with data: {}", data);
        return result;
    }



}
