package com.shaqima.subject.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: 题目答案 DTO
 * @Author: wang.yanqi
 * @CreateTime: 2024-09-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectAnswerBO implements Serializable {

    /**
     * 答案选项标识
     */
    private Integer optionType;
    /**
     * 答案
     */
    private String optionContent;
    /**
     * 是否正确
     */
    private Integer isCorrect;
}
