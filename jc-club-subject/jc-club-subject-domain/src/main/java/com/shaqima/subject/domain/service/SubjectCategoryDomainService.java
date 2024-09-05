package com.shaqima.subject.domain.service;

import com.shaqima.subject.domain.entity.SubjectCategoryBO;
import com.shaqima.subject.infra.basic.entity.SubjectCategory;

import java.util.List;

/**
 * @Description : 题目大类领域服务
 * @Author : wang.yanqi
 * @Date: 2024/9/1 16:43
 */
public interface SubjectCategoryDomainService {

    void add(SubjectCategoryBO subjectCategoryBO);

    /**
     * 更新分类
     * @param subjectCategoryBO
     * @return
     */
//    List<SubjectCategoryBO> queryPrimaryCategoryList();
    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);

    /**
     * 更新分类
     * @param subjectCategoryBO
     * @return
     */
    Boolean update(SubjectCategoryBO subjectCategoryBO);

    /**
     * 删除分类
     * @param subjectCategoryBO
     * @return
     */
    Boolean deleted(SubjectCategoryBO subjectCategoryBO);
}
