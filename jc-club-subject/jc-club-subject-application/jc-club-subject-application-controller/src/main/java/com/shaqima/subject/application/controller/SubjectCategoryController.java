package com.shaqima.subject.application.controller;

import com.alibaba.druid.util.StringUtils;
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
import java.util.List;
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
    // 注入SubjectCategoryDomainService
    private SubjectCategoryDomainService subjectCategoryDomainService;

    /**
     * @Description : 给 subject_category 表添加数据
     * @param subjectCategoryDTO
     * @return Result<Boolean>
     */
    @PostMapping("/add")
    // 添加分类
    public Result<Boolean> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try{
            if(log.isInfoEnabled()){
                // 打印日志
                log.info("subjectCategoryController.add.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }

//          参数校验(相当于断言)
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryName(), "分类名称不能为空");
            Preconditions.checkArgument(StringUtils.isEmpty(subjectCategoryDTO.getCategoryName()), "分类名称不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(), "分类父级id不能为空");

            // 将DTO转换为BO
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertDTOtoCategoryBO(subjectCategoryDTO);
            // 调用领域服务添加分类
            subjectCategoryDomainService.add(subjectCategoryBO);

            return Result.ok(true);
        }catch (Exception e){
            log.error("subjectCategoryController.add.error:{}", e.getMessage(),e);
            // 捕获异常并返回错误信息
            return Result.fail(e.getMessage());
        }
    }

    /**
     * @Description : 查询分类及标签
     * @return
     */
    @PostMapping("/queryPrimaryCategoryList")
    public Result<List<SubjectCategoryDTO>> queryPrimaryCategoryList(){
        try{
            // 查询一级分类列表
            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.queryPrimaryCategoryList();
            // 将BO转换为DTO
            List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE.convertCategoryBOtoDTOList(subjectCategoryBOList);
            // 返回成功结果
            return Result.ok(subjectCategoryDTOList);
        }catch (Exception e){
            // 记录错误日志
            log.error("subjectCategoryController.queryPrimaryCategoryList.error:{}", e.getMessage(),e);
            // 返回失败结果
            return Result.fail("查询失败");
        }


    }
}
