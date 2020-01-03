package com.bonc.oa;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages= {"com.bonc.oa.login.dao,com.bonc.oa.wanda.dao"})
public class OaApplication {
    private final static Logger logger = LoggerFactory.getLogger("oa");
    public static void main(String[] args) {
        SpringApplication.run(OaApplication.class, args);
        logger.info("OA系统启动");
    }

}
