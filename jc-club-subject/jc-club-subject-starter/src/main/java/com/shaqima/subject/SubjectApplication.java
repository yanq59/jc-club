package com.shaqima.subject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author : wang.yanqi
 * @Date: 2024/8/30 2:02
 * @Description:
 *
 * 刷题微服务启动类
 */
@SpringBootApplication
@ComponentScan("com.shaqima")
public class SubjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class);
    }
}
