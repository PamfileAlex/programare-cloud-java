package com.unitbv.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"com.unitbv.lifecycle"})
public class FunBeanCfg {

    @Bean
    DepBean depBean() {
        return new DepBean();
    }

    @Bean(initMethod = "init", destroyMethod = "delete")
    FunBean funBean(DepBean depBean) {
        FunBean funBean = new FunBean();
        funBean.setDepBean(depBean);
        return funBean;
    }
}
