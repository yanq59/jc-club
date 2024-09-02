package com.shaqima.subject.domain.service;

import com.shaqima.subject.domain.entity.SubjectCategoryBO;
import com.shaqima.subject.infra.basic.entity.SubjectCategory;

import java.util.List;

/**
 * @Description :
 * @Author : wang.yanqi
 * @Date: 2024/9/1 16:43
 */
public interface SubjectCategoryDomainService {

    void add(SubjectCategoryBO subjectCategoryBO);

    /**
     * 查询岗位大类
     */
    List<SubjectCategoryBO> queryPrimaryCategoryList();
}
