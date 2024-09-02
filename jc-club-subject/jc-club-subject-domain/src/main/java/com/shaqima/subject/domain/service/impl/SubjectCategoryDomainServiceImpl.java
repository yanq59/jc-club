package com.shaqima.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.shaqima.subject.domain.convert.SubjectCategoryConverter;
import com.shaqima.subject.domain.entity.SubjectCategoryBO;
import com.shaqima.subject.domain.service.SubjectCategoryDomainService;
import com.shaqima.subject.infra.basic.entity.SubjectCategory;
import com.shaqima.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @Description :
 * @Author : wang.yanqi
 * @Date: 2024/9/1 16:44
 */

@Service("SubjectCategoryDomainService")
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {

        // 判断日志是否启用了info级别
        if (log.isInfoEnabled()) {
            // 打印日志
            log.info("subjectCategoryController.add.bo:{}", JSON.toJSONString(subjectCategoryBO));
        }

        // 将subjectCategoryBO转换为SubjectCategory
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convertBOtoCategory(subjectCategoryBO);

        // 调用subjectCategoryService的insert方法，将subjectCategory插入数据库
        subjectCategoryService.insert(subjectCategory);
    }

    @Override
    public List<SubjectCategoryBO> queryPrimaryCategoryList() {
        SubjectCategory subjectCategory = new SubjectCategory();
        subjectCategory.setParentId(0L);

        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryParimaryCategory(subjectCategory);
        List<SubjectCategoryBO> boList = SubjectCategoryConverter.INSTANCE.convertCategoryToBO(subjectCategoryList);

        if (log.isInfoEnabled()) {
            log.info("subjectCategoryController.queryPrimaryCategoryList.boList:{}", JSON.toJSONString(boList));
        }

        return boList;
    }
}
