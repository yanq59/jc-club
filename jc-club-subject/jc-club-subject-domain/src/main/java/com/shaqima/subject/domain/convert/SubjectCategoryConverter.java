package com.shaqima.subject.domain.convert;

import com.shaqima.subject.domain.entity.SubjectCategoryBO;
import com.shaqima.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description : 将 BO 转换成 infra(基础设施层)里的 entity(实体类)
 * @Author : wang.yanqi
 * @Date: 2024/9/1 16:54
 */
@Mapper
public interface SubjectCategoryConverter {

    // 定义一个单例实例
    SubjectCategoryConverter INSTANCE = Mappers.getMapper(SubjectCategoryConverter.class);

    // 将SubjectCategoryBO转换为SubjectCategory
    SubjectCategory convertBOtoCategory(SubjectCategoryBO SubjectCategoryBO);

}
