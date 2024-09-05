package com.shaqima.subject.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 题目标签表(SubjectLabel)DTO
 *
 * @author makejava
 * @since 2024-09-05 23:44:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectLabelDTO implements Serializable {
    private static final long serialVersionUID = 906853033015302227L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 标签分类
     */
    private String labelName;
    /**
     * 排序
     */
    private Integer sortNum;




}

