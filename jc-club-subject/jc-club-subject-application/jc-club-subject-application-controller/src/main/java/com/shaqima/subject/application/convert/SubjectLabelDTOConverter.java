package com.shaqima.subject.application.convert;

import com.shaqima.subject.application.dto.SubjectLabelDTO;
import com.shaqima.subject.domain.entity.SubjectLabelBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description : 将 DTO 转换成 domain 里面的 BO
 * @Author : wang.yanqi
 * @Date: 2024/9/1 16:54
 */
@Mapper //mapstruct注解，用于定义转换器
public interface SubjectLabelDTOConverter {

    // 定义一个单例实例
    SubjectLabelDTOConverter INSTANCE = Mappers.getMapper(SubjectLabelDTOConverter.class);


    SubjectLabelBO convertLabelDTOtoBO(SubjectLabelDTO subjectLabelDTO);

    List<SubjectLabelDTO> convertLabelBOtoDTOList(List<SubjectLabelBO> boList);



}
