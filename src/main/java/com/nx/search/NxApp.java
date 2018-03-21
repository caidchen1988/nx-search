package com.nx.search;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author: caidchen
 * @create: 2018-03-20 9:50
 * To change this template use File | Settings | File Templates.
 */
@SpringBootApplication
@MapperScan(basePackages="com.nx.search.mapper")
public class NxApp {
    public static void main(String[] args) {
        SpringApplication.run(NxApp.class, args) ;
    }
}
