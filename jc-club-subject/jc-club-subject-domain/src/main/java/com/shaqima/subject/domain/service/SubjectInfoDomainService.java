package com.shaqima.subject.domain.service;

import com.shaqima.subject.common.entity.PageResult;
import com.shaqima.subject.domain.entity.SubjectInfoBO;

/**
 * @Description : 题目领域服务
 * @Author : wang.yanqi
 * @Date: 2024/9/1 16:43
 */
public interface SubjectInfoDomainService {


    /**
     * 新增题目
     * @param subjectInfoBO
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 分页查询
     * @param subjectInfoBO
     * @return
     */
    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);

    /**
     * 查询题目信息
     * @param subjectInfoBO
     * @return
     */
    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);
}
