package com.shaqima.subject.domain.handler.subject;

import com.shaqima.subject.common.enums.SubjectInfoTypeEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 题目类型的工厂
 * @Author: wang.yanqi
 * @CreateTime: 2024-09-11
 */
@Component
public class SubjectTypeHandlerFactory implements InitializingBean {

    //  @Resource 注解将会自动注入所有类型为 SubjectTypeHandler 的 bean。
    @Resource
    private List<SubjectTypeHandler> subjectTypeHandlerList;

    private Map<SubjectInfoTypeEnum, SubjectTypeHandler> handlerMap = new HashMap<>();

    // 根据subjectType获取对应的SubjectTypeHandler
    public SubjectTypeHandler getHandler(int subjectType) {
        // 根据subjectType获取对应的SubjectInfoTypeEnum
        SubjectInfoTypeEnum subjectInfoTypeEnum = SubjectInfoTypeEnum.getByCode(subjectType);
        // 从handlerMap中获取对应的SubjectTypeHandler
        return handlerMap.get(subjectInfoTypeEnum);

    }
    // 在Spring容器初始化时，会调用afterPropertiesSet方法，将所有SubjectTypeHandler放入handlerMap中
    @Override
    public void afterPropertiesSet() throws Exception {
        for (SubjectTypeHandler subjectTypeHandler : subjectTypeHandlerList)
            handlerMap.put(subjectTypeHandler.getHandlerType(), subjectTypeHandler);
    }
}
