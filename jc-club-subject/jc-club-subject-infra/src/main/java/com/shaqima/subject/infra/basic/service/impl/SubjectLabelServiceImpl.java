package com.shaqima.subject.infra.basic.service.impl;

import com.shaqima.subject.infra.basic.entity.SubjectLabel;
import com.shaqima.subject.infra.basic.mapper.SubjectLabelDao;
import com.shaqima.subject.infra.basic.service.SubjectLabelService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * 题目标签表(SubjectLabel)表服务实现类
 *
 * @author makejava
 * @since 2024-09-05 23:44:32
 */
@Service("subjectLabelService")
public class SubjectLabelServiceImpl implements SubjectLabelService {
    @Resource
    private SubjectLabelDao subjectLabelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectLabel queryById(Long id) {
        return this.subjectLabelDao.queryById(id);
    }



    /**
     * 新增数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(SubjectLabel subjectLabel) {
        return this.subjectLabelDao.insert(subjectLabel);
    }

    /**
     * 修改数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    @Override
    public int update(SubjectLabel subjectLabel) {
        return this.subjectLabelDao.update(subjectLabel);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectLabelDao.deleteById(id) > 0;
    }
}
