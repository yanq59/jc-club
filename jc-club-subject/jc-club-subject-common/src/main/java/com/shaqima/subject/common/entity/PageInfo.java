package com.shaqima.subject.common.entity;

/**
 * @Description: 分页请求实体
 * @Author: wang.yanqi
 * @CreateTime: 2024-09-12
 */
public class PageInfo {

    private Integer pageNo = 1;

    private Integer pageSize = 20;

    public Integer getPageNo(){
        if (pageNo == null || pageNo <= 0) {
            return 1;
        }
        return pageNo;
    }

    public Integer getPageSize(){
        if (pageSize == null || pageSize <= 0 || pageSize > Integer.MAX_VALUE) {
            return 20;
        }
        return pageSize;
    }
}
