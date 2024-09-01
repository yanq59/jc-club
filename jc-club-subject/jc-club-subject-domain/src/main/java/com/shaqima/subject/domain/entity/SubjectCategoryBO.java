package com.shaqima.subject.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * BO: 领域的数据对象
 * 题目分类(SubjectCategory)实体类
 *
 * @author makejava
 * @since 2024-08-31 00:17:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectCategoryBO implements Serializable {
    private static final long serialVersionUID = 257201127465166903L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 分类类型
     */
    private Integer categoryType;
    /**
     * 图标连接
     */
    private String imageUrl;
    /**
     * 父级id
     */
    private Long parentId;


}

