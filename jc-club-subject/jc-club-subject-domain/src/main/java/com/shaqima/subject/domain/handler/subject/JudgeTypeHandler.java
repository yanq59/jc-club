package com.shaqima.subject.domain.handler.subject;

import com.shaqima.subject.common.enums.IsDeletedFlagEnum;
import com.shaqima.subject.common.enums.SubjectInfoTypeEnum;
import com.shaqima.subject.domain.entity.SubjectAnswerBO;
import com.shaqima.subject.domain.entity.SubjectInfoBO;
import com.shaqima.subject.infra.basic.entity.SubjectJudge;
import com.shaqima.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description: 判断的题目的策略类
 * @Author: wang.yanqi
 * @CreateTime: 2024-09-11
 */
@Component
public class JudgeTypeHandler implements SubjectTypeHandler{
    @Resource
    private SubjectJudgeService subjectJudgeService;

//    说明当前的策略只能处理单选的
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
//        判断题目的插入
        SubjectJudge subjectJudge = new SubjectJudge();
        SubjectAnswerBO subjectAnswerBO = subjectInfoBO.getOptionList().get(0);
        subjectJudge.setSubjectId(subjectInfoBO.getId());
        subjectJudge.setIsCorrect(subjectAnswerBO.getIsCorrect());
        subjectJudge.setIsDeleted(IsDeletedFlagEnum.NO_DELETED.getCode());
        subjectJudgeService.insert(subjectJudge);
    }
}
