package com.shaqima.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.shaqima.subject.application.convert.SubjectLabelDTOConverter;
import com.shaqima.subject.application.dto.SubjectLabelDTO;
import com.shaqima.subject.common.entity.Result;
import com.shaqima.subject.domain.entity.SubjectLabelBO;
import com.shaqima.subject.domain.service.SubjectLabelDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 标签controller
 * @Author: wang.yanqi
 * @CreateTime: 2024-09-05
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/subject/label")
@Slf4j //log4j注解
public class SubjectLabelController {

    @Resource
    private SubjectLabelDomainService subjectLabelDomainService;

    /**
     * 新增标签
     * @param subjectLabelDTO
     * @return
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectLabelDTO subjectLabelDTO){
        try{
            if(log.isInfoEnabled()){
                // 打印日志
                log.info("SubjectLabelController.add.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }

//          参数校验(相当于断言)
//          如果不满足条件直接 异常 走 catch 那步
            Preconditions.checkNotNull(subjectLabelDTO.getLabelName(), "标签名称不能为空");

            // 将DTO转换为BO
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.convertLabelDTOtoBO(subjectLabelDTO);
            // 调用领域服务添加分类
            Boolean result = subjectLabelDomainService.add(subjectLabelBO);

            return Result.ok(result);
        }catch (Exception e){
            log.error("SubjectLabelController.add.error:{}", e);
            // 捕获异常并返回错误信息
            return Result.fail("新增标签失败");
        }
    }

    /**
     * 更新标签
     * @param subjectLabelDTO
     * @return
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectLabelDTO subjectLabelDTO){
        try{
            if(log.isInfoEnabled()){
                // 打印日志
                log.info("SubjectLabelController.update.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }

//          参数校验(相当于断言)
//          如果不满足条件直接 异常 走 catch 那步
            Preconditions.checkNotNull(subjectLabelDTO.getId(), "标签id不能为空");

            // 将DTO转换为BO
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.convertLabelDTOtoBO(subjectLabelDTO);
            // 调用领域服务添加分类
            Boolean result = subjectLabelDomainService.update(subjectLabelBO);

            return Result.ok(result);
        }catch (Exception e){
            log.error("SubjectLabelController.update.error:{}", e);
            // 捕获异常并返回错误信息
            return Result.fail("更新标签失败");
        }
    }

    /**
     * 删除标签
     * @param subjectLabelDTO
     * @return
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectLabelDTO subjectLabelDTO){
        try{
            if(log.isInfoEnabled()){
                // 打印日志
                log.info("SubjectLabelController.delete.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }

//          参数校验(相当于断言)
//          如果不满足条件直接 异常 走 catch 那步
            Preconditions.checkNotNull(subjectLabelDTO.getId(), "标签id不能为空");

            // 将DTO转换为BO
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.convertLabelDTOtoBO(subjectLabelDTO);
            // 调用领域服务添加分类
            Boolean result = subjectLabelDomainService.delete(subjectLabelBO);

            return Result.ok(result);
        }catch (Exception e){
            log.error("SubjectLabelController.delete.error:{}", e);
            // 捕获异常并返回错误信息
            return Result.fail("删除标签失败");
        }
    }

    /**
     * 查询分类下的标签
     * @param subjectLabelDTO
     * @return
     */
    @PostMapping("/queryLabelByCategoryId")
    public Result<List<SubjectLabelDTO>> queryLabelByCategoryId(@RequestBody SubjectLabelDTO subjectLabelDTO){
        try{
            if(log.isInfoEnabled()){
                // 打印日志
                log.info("SubjectLabelController.queryLabelByCategoryId.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }

//          参数校验(相当于断言)
//          如果不满足条件直接 异常 走 catch 那步
            Preconditions.checkNotNull(subjectLabelDTO.getCategoryId(), "分类的id不能为空");

            // 将DTO转换为BO
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.convertLabelDTOtoBO(subjectLabelDTO);

            // 调用领域服务添加分类
            List<SubjectLabelBO> resultList = subjectLabelDomainService.queryLabelByCategoryId(subjectLabelBO);

            List<SubjectLabelDTO> subjectLabelDTOS = SubjectLabelDTOConverter.INSTANCE.convertLabelBOtoDTOList(resultList);
            return Result.ok(subjectLabelDTOS);
        }catch (Exception e){
            log.error("SubjectLabelController.queryLabelByCategoryId.error:{}", e);
            // 捕获异常并返回错误信息
            return Result.fail("查询分类下标签失败");
        }
    }

}
