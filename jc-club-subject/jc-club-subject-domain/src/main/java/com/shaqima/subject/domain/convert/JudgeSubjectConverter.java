package com.shaqima.subject.domain.convert;

import com.shaqima.subject.domain.entity.SubjectAnswerBO;
import com.shaqima.subject.infra.basic.entity.SubjectJudge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description:
 * @Author: wang.yanqi
 * @CreateTime: 2024-09-12
 */
@Mapper
public interface JudgeSubjectConverter {
    JudgeSubjectConverter INSTANCE = Mappers.getMapper(JudgeSubjectConverter.class);

    List<SubjectAnswerBO> convertEntityToBoList(List<SubjectJudge> subjectJudgeList);
}
