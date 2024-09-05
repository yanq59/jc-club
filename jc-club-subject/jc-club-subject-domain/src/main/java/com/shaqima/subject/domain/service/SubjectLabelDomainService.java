package com.shaqima.subject.domain.service;

import com.shaqima.subject.domain.entity.SubjectLabelBO;

import java.util.List;

/**
 * @Description : 题目标签领域服务
 * @Author : wang.yanqi
 * @Date: 2024/9/1 16:43
 */
public interface SubjectLabelDomainService {


    /**
     * 新增标签
     * @param subjectLabelBO
     */
    Boolean add(SubjectLabelBO subjectLabelBO);


    /**
     * 更新标签
     * @param subjectLabelBO
     * @return
     */
    Boolean update(SubjectLabelBO subjectLabelBO);

    /**
     * 删除标签
     * @param subjectLabelBO
     * @return
     */
    Boolean delete(SubjectLabelBO subjectLabelBO);

    /**
     * 查询 分类下标签
     * @param subjectLabelBO
     * @return
     */
    List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO);
}
