package com.unitbv.stereotype;

import com.unitbv.stereotype.controller.UserController;
import com.unitbv.stereotype.repository.UserRepository;
import com.unitbv.stereotype.repository.impl.UserRepositoryImpl;
import com.unitbv.stereotype.service.UserService;
import com.unitbv.stereotype.service.impl.UserServiceImpl;
import com.unitbv.stereotype.util.UserUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.unitbv.stereotype")
public class StereotypeCfg {

    @Bean
    UserController userController() {
        return new UserController();
    }

    @Bean
    UserServiceImpl userServiceImpl() {
        return new UserServiceImpl();
    }

    @Bean
    UserRepositoryImpl userRepositoryImpl() {
        return new UserRepositoryImpl();
    }

    @Bean
    UserUtil userUtil() {
        return new UserUtil();
    }
}
