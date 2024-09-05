package com.shaqima.subject.domain.convert;

import com.shaqima.subject.domain.entity.SubjectLabelBO;
import com.shaqima.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description : 将 BO 转换成 infra(基础设施层)里的 entity(实体类)
 * @Author : wang.yanqi
 * @Date: 2024/9/1 16:54
 */
@Mapper
public interface SubjectLabelConverter {

    // 定义一个单例实例
    SubjectLabelConverter INSTANCE = Mappers.getMapper(SubjectLabelConverter.class);

    // 将SubjectCategoryBO转换为SubjectCategory
    SubjectLabel convertBOtoLabel(SubjectLabelBO subjectLabelBO);


    List<SubjectLabelBO> convertLabelToBO(List<SubjectLabel> subjectLabelList);


}
