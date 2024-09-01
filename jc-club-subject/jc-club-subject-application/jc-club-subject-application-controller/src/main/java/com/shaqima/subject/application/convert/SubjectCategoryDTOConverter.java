package com.shaqima.subject.application.convert;

import com.shaqima.subject.application.dto.SubjectCategoryDTO;
import com.shaqima.subject.domain.entity.SubjectCategoryBO;
import com.shaqima.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description : 将 DTO 转换成 domain 里面的 BO
 * @Author : wang.yanqi
 * @Date: 2024/9/1 16:54
 */
@Mapper //mapstruct注解，用于定义转换器
public interface SubjectCategoryDTOConverter {

    // 定义一个单例实例
    SubjectCategoryDTOConverter INSTANCE = Mappers.getMapper(SubjectCategoryDTOConverter.class);

    // 将SubjectCategoryDTO转换为SubjectCategoryBO
    SubjectCategoryBO convertDTOtoCategoryBO(SubjectCategoryDTO SubjectCategoryDTO);
}
