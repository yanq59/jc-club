package com.shaqima.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.shaqima.subject.common.enums.IsDeletedFlagEnum;
import com.shaqima.subject.domain.convert.SubjectLabelConverter;
import com.shaqima.subject.domain.entity.SubjectLabelBO;
import com.shaqima.subject.domain.service.SubjectLabelDomainService;
import com.shaqima.subject.infra.basic.entity.SubjectLabel;
import com.shaqima.subject.infra.basic.entity.SubjectMapping;
import com.shaqima.subject.infra.basic.service.SubjectLabelService;
import com.shaqima.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
*@Description: 
*@Author: wang.yanqi
*@CreateTime: 2024-09-06
*/

@Service
@Slf4j
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Resource
    private SubjectLabelService subjectLabelService;
    @Resource
    private SubjectMappingService subjectMappingService;

    @Override
    public Boolean add(SubjectLabelBO subjectLabelBO) {
        // 判断日志是否启用了info级别
        if (log.isInfoEnabled()) {
            // 打印日志
            log.info("SubjectLabelDomainServiceImpl.add.bo:{}", JSON.toJSONString(subjectLabelBO));
        }

        // 将subjectCategoryBO转换为SubjectCategory
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBOtoLabel(subjectLabelBO);

        subjectLabel.setIsDeleted(IsDeletedFlagEnum.NO_DELETED.getCode());
        // 调用subjectCategoryService的insert方法，将subjectCategory插入数据库
        int count = subjectLabelService.insert(subjectLabel);
        return count > 0;

    }

    @Override
    public Boolean update(SubjectLabelBO subjectLabelBO) {
        // 判断日志是否启用了info级别
        if (log.isInfoEnabled()) {
            // 打印日志
            log.info("SubjectLabelDomainServiceImpl.update.bo:{}", JSON.toJSONString(subjectLabelBO));
        }

        // 将subjectCategoryBO转换为SubjectCategory
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBOtoLabel(subjectLabelBO);

        // 调用subjectCategoryService的insert方法，将subjectCategory插入数据库
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }

    @Override
    public Boolean delete(SubjectLabelBO subjectLabelBO) {
        // 判断日志是否启用了info级别
        if (log.isInfoEnabled()) {
            // 打印日志
            log.info("SubjectLabelDomainServiceImpl.delete.bo:{}", JSON.toJSONString(subjectLabelBO));
        }

        // 将subjectCategoryBO转换为SubjectCategory
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBOtoLabel(subjectLabelBO);

        subjectLabel.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;


    }

    @Override
    public List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO) {
        Long categoryId = subjectLabelBO.getCategoryId();

        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setCategoryId(categoryId);
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.NO_DELETED.getCode());
//        查询标签id
        List<SubjectMapping> mappingList = subjectMappingService.queryLabelId(subjectMapping);

        if(CollectionUtils.isEmpty(mappingList)){
            return Collections.emptyList();
        }

        /**
         * SubjectMapping::getLabelId 是一个方法引用，它指向 SubjectMapping 类的 getLabelId 方法。
         * 这个操作会将 Stream 中的每个 SubjectMapping 对象转换成它的 labelId。
         */
        List<Long> labelIdList =  mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> labelList = subjectLabelService.batchQueryById(labelIdList);
        List<SubjectLabelBO> boList = new LinkedList<>();
        labelList.forEach(label -> {
            SubjectLabelBO bo = new SubjectLabelBO();
            bo.setId(label.getId());
            bo.setLabelName(label.getLabelName());
            bo.setCategoryId(categoryId);
            bo.setSortNum(label.getSortNum());
            boList.add(bo);
        });
        return boList;
    }

}
