package com.shaqima.subject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 刷题微服务启动类
 *
 * @Author : wang.yanqi
 * @Date: 2024/8/30 2:02
 */
@SpringBootApplication
@ComponentScan("com.shaqima")
@MapperScan("com.shaqima.**.mapper") // 扫描mapper接口(扫码dao层)
public class SubjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class);
    }
}
