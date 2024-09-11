package com.shaqima.subject.domain.convert;

import com.shaqima.subject.domain.entity.SubjectInfoBO;
import com.shaqima.subject.infra.basic.entity.SubjectBrief;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description:
 * @Author: wang.yanqi
 * @CreateTime: 2024-09-12
 */
@Mapper
public interface BriefSubjectConverter {
    BriefSubjectConverter INSTANCE = Mappers.getMapper(BriefSubjectConverter.class);

    SubjectBrief convertBoToEntity(SubjectInfoBO subjectInfoBO);
}
