package com.shaqima.subject.domain.handler.subject;

import com.shaqima.subject.common.enums.IsDeletedFlagEnum;
import com.shaqima.subject.common.enums.SubjectInfoTypeEnum;
import com.shaqima.subject.domain.convert.RadioSubjectConverter;
import com.shaqima.subject.domain.entity.SubjectInfoBO;
import com.shaqima.subject.infra.basic.entity.SubjectRadio;
import com.shaqima.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 单选的题目的策略类
 * @Author: wang.yanqi
 * @CreateTime: 2024-09-11
 */
@Component
public class RadioTypeHandler implements SubjectTypeHandler{
    @Resource
    private SubjectRadioService subjectRadioService;

//    说明当前的策略只能处理单选的
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
//        单选题目的插入
        List<SubjectRadio> subjectRadioList = new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectRadio subjectRadio = RadioSubjectConverter.INSTANCE.convertBOtoRadio(option);
            subjectRadio.setSubjectId(subjectInfoBO.getId());
            subjectRadio.setIsDeleted(IsDeletedFlagEnum.NO_DELETED.getCode());
            subjectRadioList.add(subjectRadio);
        });
        subjectRadioService.batchInsert(subjectRadioList);

    }
}
