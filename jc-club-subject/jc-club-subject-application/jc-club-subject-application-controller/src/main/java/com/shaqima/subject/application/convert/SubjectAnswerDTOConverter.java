package com.shaqima.subject.application.convert;

import com.shaqima.subject.application.dto.SubjectAnswerDTO;
import com.shaqima.subject.application.dto.SubjectCategoryDTO;
import com.shaqima.subject.domain.entity.SubjectAnswerBO;
import com.shaqima.subject.domain.entity.SubjectCategoryBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description : 将 DTO 转换成 domain 里面的 BO
 * @Author : wang.yanqi
 * @Date: 2024/9/1 16:54
 */
@Mapper //mapstruct注解，用于定义转换器
public interface SubjectAnswerDTOConverter {

    // 定义一个单例实例
    SubjectAnswerDTOConverter INSTANCE = Mappers.getMapper(SubjectAnswerDTOConverter.class);

    SubjectAnswerBO convertAnswerDTOtoBO(SubjectAnswerDTO subjectAnswerDTO);

    List<SubjectAnswerBO> convertAnswerListDTOtoBO(List<SubjectAnswerDTO> subjectAnswerDTOList);

    // 将SubjectCategoryBO转换为SubjectCategoryDTO
    List<SubjectCategoryDTO> convertCategoryBOtoDTOList(List<SubjectCategoryBO> subjectCategoryBOList);


}
