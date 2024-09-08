package com.shaqima.subject.domain.convert;

import com.shaqima.subject.domain.entity.SubjectCategoryBO;
import com.shaqima.subject.domain.entity.SubjectInfoBO;
import com.shaqima.subject.infra.basic.entity.SubjectCategory;
import com.shaqima.subject.infra.basic.entity.SubjectInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description : 将 BO 转换成 infra(基础设施层)里的 entity(实体类)
 * @Author : wang.yanqi
 * @Date: 2024/9/1 16:54
 */
@Mapper
public interface SubjectInfoConverter {

    // 定义一个单例实例
    SubjectInfoConverter INSTANCE = Mappers.getMapper(SubjectInfoConverter.class);

    // 将SubjectInfoBO转换为SubjectInfo
    SubjectInfo convertBOtoInfo(SubjectInfoBO subjectInfoBO);

    List<SubjectCategoryBO> convertCategoryToBO(List<SubjectCategory> subjectCategoryList);


}
