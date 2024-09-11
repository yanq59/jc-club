package com.shaqima.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.shaqima.subject.domain.convert.SubjectInfoConverter;
import com.shaqima.subject.domain.entity.SubjectInfoBO;
import com.shaqima.subject.domain.handler.subject.SubjectTypeHandler;
import com.shaqima.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.shaqima.subject.domain.service.SubjectInfoDomainService;
import com.shaqima.subject.infra.basic.entity.SubjectInfo;
import com.shaqima.subject.infra.basic.entity.SubjectMapping;
import com.shaqima.subject.infra.basic.service.SubjectInfoService;
import com.shaqima.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
*@Description: 
*@Author: wang.yanqi
*@CreateTime: 2024-09-06
*/

@Service
@Slf4j
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {

    @Resource
    private SubjectInfoService subjectInfoService;
    @Resource
    private SubjectMappingService subjectMappingService;
    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory; //注入工厂

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 判断日志是否启用了info级别
        if (log.isInfoEnabled()) {
            // 打印日志
            log.info("SubjectInfoDomainServiceImpl.add.bo:{}", JSON.toJSONString(subjectInfoBO));
        }
//        假设我们都写在主流程中
//        判断type,单选的调用单选的service 多选的调用多选的
//        一堆if
//        上一个工厂+ 策略
//        一个工厂包含4中类型, 根据传入的type自动映射选择处理
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.convertBOtoInfo(subjectInfoBO);
        subjectInfoService.insert(subjectInfo);

//        工厂模式
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        handler.add(subjectInfoBO);

        List<Integer> categoryIds = subjectInfoBO.getCategoryIds();
        List<Integer> labelIds = subjectInfoBO.getLabelIds();
        List<SubjectMapping> mappingList = new LinkedList<>();
        categoryIds.forEach(categoryId->{
            labelIds.forEach(labelId->{
                SubjectMapping subjectMapping = new SubjectMapping();
                subjectMapping.setSubjectId(subjectInfo.getId());
                subjectMapping.setCategoryId(Long.valueOf(categoryId));
                subjectMapping.setLabelId(Long.valueOf(labelId));
                mappingList.add(subjectMapping);
            });
        });
        subjectMappingService.batchInsert(mappingList);

    }
}
