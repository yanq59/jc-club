package com.shaqima.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.shaqima.subject.application.convert.SubjectCategoryDTOConverter;
import com.shaqima.subject.application.dto.SubjectCategoryDTO;
import com.shaqima.subject.common.entity.Result;
import com.shaqima.subject.domain.entity.SubjectCategoryBO;
import com.shaqima.subject.domain.service.SubjectCategoryDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Description : 刷题分类 controller
 * @Author : wang.yanqi
 * @Date: 2024/9/1 17:10
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/subject/category")
@Slf4j //log4j注解
public class SubjectCategoryController {

    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try{
            if(log.isInfoEnabled()){
                log.info("subjectCategoryController.add.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }

//            Preconditions

            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertDTOtoCategoryBO(subjectCategoryDTO);
            subjectCategoryDomainService.add(subjectCategoryBO);
            return Result.ok(true);
        }catch (Exception e){
            return Result.fail();
        }
    }
}
