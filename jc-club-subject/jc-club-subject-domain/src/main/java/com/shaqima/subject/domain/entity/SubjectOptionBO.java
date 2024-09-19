package com.shaqima.subject.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 题目的DTO
 * @author makejava
 * @since 2024-09-09 00:11:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectOptionBO implements Serializable {
    private static final long serialVersionUID = 767007477552274931L;

    /**
     * 题目答案
     */
    private String subjectAnswer;

    /**
     * 答案选项
     */
    private List<SubjectAnswerBO> optionList;






}

