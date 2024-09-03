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
import java.util.Date;
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
    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {

        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convertBOtoCategory(subjectCategoryBO);

        // 将查询结果转换为BO对象
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);
        List<SubjectCategoryBO> boList = SubjectCategoryConverter.INSTANCE.convertCategoryToBO(subjectCategoryList);

        if (log.isInfoEnabled()) {
            log.info("subjectCategoryDomainServiceImpl.queryCategory.boList:{}", JSON.toJSONString(boList));
        }

        return boList;
    }

    @Override
    public Boolean update(SubjectCategoryBO subjectCategoryBO) {
        if (log.isInfoEnabled()) {
            log.info("subjectCategoryDomainServiceImpl.update.subjectCategoryBO:{}", JSON.toJSONString(subjectCategoryBO));
        }
        // 将subjectCategoryBO转换为SubjectCategory
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convertBOtoCategory(subjectCategoryBO);
        if (log.isInfoEnabled()) {
            log.info("subjectCategoryDomainServiceImpl.update.subjectCategory:{}", JSON.toJSONString(subjectCategoryBO));
        }
        SubjectCategory subjectCategory1 = new SubjectCategory(1L,"houdan",1,"url",2L,"SS",new Date(),"SS",new Date(),1);
        // 更新subjectCategory
        int count = subjectCategoryService.update(subjectCategory1);
//        int count = subjectCategoryService.update(subjectCategory);

        // 返回更新结果
        return count > 0;
    }
}
