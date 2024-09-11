package com.shaqima.subject.domain.handler.subject;

import com.shaqima.subject.common.enums.IsDeletedFlagEnum;
import com.shaqima.subject.common.enums.SubjectInfoTypeEnum;
import com.shaqima.subject.domain.convert.MultipleSubjectConverter;
import com.shaqima.subject.domain.entity.SubjectInfoBO;
import com.shaqima.subject.infra.basic.entity.SubjectMultiple;
import com.shaqima.subject.infra.basic.service.SubjectMultipleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 多选的题目的策略类
 * @Author: wang.yanqi
 * @CreateTime: 2024-09-11
 */
@Component
public class MultipleTypeHandler implements SubjectTypeHandler{
    @Resource
    private SubjectMultipleService subjectMultipleService;

//    说明当前的策略只能处理单选的
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.MULTIPLE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
//        多选题目的插入
        List<SubjectMultiple> subjectMultipleList = new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectMultiple subjectMultiple = MultipleSubjectConverter.INSTANCE.convertBOtoMultiple(option);
            subjectMultiple.setSubjectId(subjectInfoBO.getId());
            subjectMultiple.setIsDeleted(IsDeletedFlagEnum.NO_DELETED.getCode());
            subjectMultipleList.add(subjectMultiple);
        });
        subjectMultipleService.batchInsert(subjectMultipleList);
    }
}
