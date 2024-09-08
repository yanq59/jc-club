package com.shaqima.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.shaqima.subject.domain.entity.SubjectInfoBO;
import com.shaqima.subject.domain.service.SubjectInfoDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
*@Description: 
*@Author: wang.yanqi
*@CreateTime: 2024-09-06
*/

@Service
@Slf4j
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {

    @Override
    public Boolean add(SubjectInfoBO subjectInfoBO) {
        // 判断日志是否启用了info级别
        if (log.isInfoEnabled()) {
            // 打印日志
            log.info("SubjectInfoDomainServiceImpl.add.bo:{}", JSON.toJSONString(subjectInfoBO));
        }
        return null;
    }
}
