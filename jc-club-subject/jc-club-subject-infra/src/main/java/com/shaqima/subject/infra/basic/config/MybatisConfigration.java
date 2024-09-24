package com.shaqima.subject.infra.basic.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: wang.yanqi
 * @CreateTime: 2024-09-24
 */
@Configuration
public class MybatisConfigration {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new MybatisPlusAllSqlLog());
        return interceptor;
    }
}
