package com.shaqima.subject.application.controller;

import com.shaqima.subject.infra.basic.entity.SubjectCategory;
import com.shaqima.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 刷题 controller
 *
 * @Author : wang.yanqi
 * @Date: 2024/8/30 22:44
 */
@CrossOrigin("*")
@RestController
//@RequestMapping("/neu/qqq")
public class SubjectController {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @GetMapping("/test")
    public String test(){
        SubjectCategory subjectCategory = subjectCategoryService.queryById(1L);
        return subjectCategory.getCategoryName();
    }
}
