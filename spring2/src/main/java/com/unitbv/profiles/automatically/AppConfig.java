package com.unitbv.profiles.automatically;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.ConfigurableEnvironment;

@Configuration
@ComponentScan
@PropertySource("classpath:profiles.properties")
public class AppConfig {

}
