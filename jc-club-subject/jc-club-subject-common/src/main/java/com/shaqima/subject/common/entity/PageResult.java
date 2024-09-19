package com.shaqima.subject.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 分页返回的实体
 * @Author: wang.yanqi
 * @CreateTime: 2024-09-12
 */
@Data
public class PageResult<T> implements Serializable {

    private Integer pageNo = 1; // 当前页码

    private Integer pageSize = 20; // 每页显示的条数

    private Integer total = 0; // 总条数

    private Integer totalPages = 0; // 总页数

    private List<T> result = Collections.emptyList(); // 结果集

    private Integer start = 1; // 当前页的起始条数

    private Integer end = 0; // 当前页的结束条数

    public void setRecords(List<T> result) {
        this.result = result;
        if (result != null && result.size() > 0) {
            setTotal(result.size());
        }
    }

    // 设置总记录数 分页
    public void setTotal(Integer total) {
        // 将总记录数赋值给成员变量
        this.total = total;
        // 如果每页记录数大于0
        if (this.pageSize > 0) {
            // 计算总页数
            this.totalPages = (total / this.pageSize) + (total % this.pageSize == 0 ? 0 : 1);
        } else {
            // 否则总页数为0
            this.totalPages = 0;
        }
        // 计算起始记录数
        this.start = (this.pageSize > 0 ? (this.pageNo - 1) * this.pageSize : 0) + 1;
        // 计算结束记录数
        this.end = (this.start - 1 + this.pageSize * (this.pageNo > 0 ? 1 : 0));
    }

    public void setPageSize(Integer pageSize){
        this.pageSize = pageSize;
    }

    public void setPageNo(Integer pageNo){
        this.pageNo = pageNo;
    }
}
