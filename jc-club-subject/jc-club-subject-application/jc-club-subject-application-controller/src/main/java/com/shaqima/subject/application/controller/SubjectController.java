package com.shaqima.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.base.Preconditions;
import com.shaqima.subject.application.convert.SubjectAnswerDTOConverter;
import com.shaqima.subject.application.convert.SubjectInfoDTOConverter;
import com.shaqima.subject.application.dto.SubjectInfoDTO;
import com.shaqima.subject.common.entity.PageResult;
import com.shaqima.subject.common.entity.Result;
import com.shaqima.subject.domain.entity.SubjectAnswerBO;
import com.shaqima.subject.domain.entity.SubjectInfoBO;
import com.shaqima.subject.domain.service.SubjectInfoDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 题目模块 controller
 * @Author: wang.yanqi
 * @CreateTime: 2024-09-09
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/subject")
@Slf4j
public class SubjectController {

    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;

    /**
     * 新增题目 工厂+策略
     * @param subjectInfoDTO
     * @return
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO){
        try{
            if(log.isInfoEnabled()){
                // 打印日志
                log.info("subjectController.add.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }

//          参数校验(相当于断言)
//          如果不满足条件直接 异常 走 catch 那步
            Preconditions.checkArgument(!StringUtils.isBlank(subjectInfoDTO.getSubjectName()), "题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(), "题目难度不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(), "题目分数不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getCategoryIds()), "分类id不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getLabelIds()), "标签id不能为空");

            // 将DTO转换为BO
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertInfoDTOtoBO(subjectInfoDTO);
            List<SubjectAnswerBO> subjectAnswerBOS = SubjectAnswerDTOConverter.INSTANCE.convertAnswerListDTOtoBO(subjectInfoDTO.getOptionList());
            subjectInfoBO.setOptionList(subjectAnswerBOS);

            // 调用领域服务添加分类
            subjectInfoDomainService.add(subjectInfoBO);

            return Result.ok(true);
        }catch (Exception e){
            log.error("SubjectController.add.error:{}", e.getMessage(),e);
            // 捕获异常并返回错误信息
            return Result.fail("新增题目失败");
        }
    }


    /**
     * 查询题目列表
     * @param subjectInfoDTO
     * @return
     */
    @PostMapping("/getSubjectPage")
    public Result<PageResult<SubjectInfoDTO>> getSubjectPage(@RequestBody SubjectInfoDTO subjectInfoDTO){
        try{
            if(log.isInfoEnabled()){
                // 打印日志
                log.info("subjectController.getSubjectPage.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }

//          参数校验(相当于断言)
//          如果不满足条件直接 异常 走 catch 那步
            Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(), "分类id不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getLabelId(), "标签id不能为空");

            // 将DTO转换为BO
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertInfoDTOtoBO(subjectInfoDTO);

            // 调用领域服务添加分类
            PageResult<SubjectInfoBO> PageResultBO = subjectInfoDomainService.getSubjectPage(subjectInfoBO);

            return Result.ok(PageResultBO);
        }catch (Exception e){
            log.error("SubjectController.add.error:{}", e.getMessage(),e);
            // 捕获异常并返回错误信息
            return Result.fail("分页查询题目失败");
        }
    }

    /**
     * 查询题目详情
     * @param subjectInfoDTO
     * @return
     */
    @PostMapping("/querySubjectInfo")
    public Result<SubjectInfoDTO> querySubjectInfo(@RequestBody SubjectInfoDTO subjectInfoDTO){
        try{
            if(log.isInfoEnabled()){
                // 打印日志
                log.info("subjectController.querySubjectInfo.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }

//          参数校验(相当于断言)
//          如果不满足条件直接 异常 走 catch 那步
            Preconditions.checkNotNull(subjectInfoDTO.getId(), "题目id不能为空");

            // 将DTO转换为BO
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertInfoDTOtoBO(subjectInfoDTO);

            // 调用领域服务添加分类
            SubjectInfoBO ResultBO = subjectInfoDomainService.querySubjectInfo(subjectInfoBO);
            SubjectInfoDTO dto = SubjectInfoDTOConverter.INSTANCE.convertInfoBOtoDTO(ResultBO);

            return Result.ok(dto);
        }catch (Exception e){
            log.error("SubjectController.add.error:{}", e.getMessage(),e);
            // 捕获异常并返回错误信息
            return Result.fail("查询题目详情失败");
        }
    }
}
