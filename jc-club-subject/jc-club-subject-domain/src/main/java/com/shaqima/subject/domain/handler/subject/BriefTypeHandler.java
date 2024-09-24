package com.shaqima.subject.domain.handler.subject;

import com.shaqima.subject.common.enums.IsDeletedFlagEnum;
import com.shaqima.subject.common.enums.SubjectInfoTypeEnum;
import com.shaqima.subject.domain.convert.BriefSubjectConverter;
import com.shaqima.subject.domain.entity.SubjectInfoBO;
import com.shaqima.subject.domain.entity.SubjectOptionBO;
import com.shaqima.subject.infra.basic.entity.SubjectBrief;
import com.shaqima.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description: 简答的题目的策略类
 * @Author: wang.yanqi
 * @CreateTime: 2024-09-11
 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler{
    @Resource
    private SubjectBriefService subjectBriefService;

//    说明当前的策略只能处理单选的
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
//        简答的插入
        SubjectBrief subjectBrief = BriefSubjectConverter.INSTANCE.convertBoToEntity(subjectInfoBO);
        subjectBrief.setSubjectId(subjectInfoBO.getId().intValue());
        subjectBrief.setIsDeleted(IsDeletedFlagEnum.NO_DELETED.getCode());
        subjectBriefService.insert(subjectBrief);
    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectBrief subjectBrief = new SubjectBrief();
        subjectBrief.setSubjectId(subjectId);
        SubjectBrief result = subjectBriefService.queryByCondition(subjectBrief);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setSubjectAnswer(result.getSubjectAnswer());
        return subjectOptionBO;
    }
}
