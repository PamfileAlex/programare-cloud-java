package com.unitbv.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//public class FunBean implements InitializingBean, DisposableBean, ApplicationContextAware {
public class FunBean implements InitializingBean, DisposableBean {
    private Logger logger = LoggerFactory.getLogger(FunBean.class);

    private DepBean depBean;

    public FunBean() {
        logger.debug("Constructor");
    }

    public void setDepBean(DepBean depBean) {
        this.depBean = depBean;
        logger.debug("DepBean setter");
    }

    public void init() {
        logger.debug("Init");
    }

    public void delete() {
        logger.debug("Delete");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.debug("InitializingBean");
    }

    @Override
    public void destroy() throws Exception {
        logger.debug("DisposableBean");
    }

    @PostConstruct
    public void postConstruct() {
        logger.debug("PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        logger.debug("PreDestroy");
    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        logger.debug("SetApplicationContext");
//    }
}
