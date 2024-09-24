package com.shaqima.subject.domain.convert;

import com.shaqima.subject.domain.entity.SubjectAnswerBO;
import com.shaqima.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description : 将 BO 转换成 infra(基础设施层)里的 entity(实体类)
 * @Author : wang.yanqi
 * @Date: 2024/9/1 16:54
 */
@Mapper
public interface RadioSubjectConverter {

    // 定义一个单例实例
    RadioSubjectConverter INSTANCE = Mappers.getMapper(RadioSubjectConverter.class);

    // 将SubjectInfoBO转换为SubjectInfo
    SubjectRadio convertBOtoRadio(SubjectAnswerBO subjectAnswerBO);

    List<SubjectAnswerBO> convertEntityToBoList(List<SubjectRadio> subjectRadioList);


}
