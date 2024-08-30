package com.shaqima.subject.application.controller;

import com.shaqima.subject.infra.basic.entity.SubjectCategory;
import com.shaqima.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 刷题 controller
 *
 * @Author : wang.yanqi
 * @Date: 2024/8/30 22:44
 */
@RestController
public class SubjectController {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @GetMapping("/test")
    public String test(){
        SubjectCategory subjectCategory = subjectCategoryService.queryById(1L);
        return subjectCategory.getCategoryName();
    }
}
