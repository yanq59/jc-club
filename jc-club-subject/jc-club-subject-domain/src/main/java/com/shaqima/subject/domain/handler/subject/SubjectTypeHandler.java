package com.shaqima.subject.domain.handler.subject;

import com.shaqima.subject.common.enums.SubjectInfoTypeEnum;
import com.shaqima.subject.domain.entity.SubjectInfoBO;

/**
 * @Description:
 * @Author: wang.yanqi
 * @CreateTime: 2024-09-11
 */

public interface SubjectTypeHandler {

    /**
     * 枚举身份的识别
     * @return
     */
    SubjectInfoTypeEnum getHandlerType();

    /**
     * 实际的题目的插入
     * @param subjectInfoBO
     */
    void add(SubjectInfoBO subjectInfoBO);

}
