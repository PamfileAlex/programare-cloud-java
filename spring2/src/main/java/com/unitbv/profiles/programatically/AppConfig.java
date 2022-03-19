package com.unitbv.profiles.programatically;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean
    @Profile("default")
    public DataSourceConfig getDefaultDataSourceConfig(){
        return new DevDataSourceConfig();
    }

    @Bean
    @Profile("dev")
    public DataSourceConfig getDevDataSourceConfig(){
        return new DevDataSourceConfig();
    }

    @Bean
    @Profile("prod")
    public DataSourceConfig getProdDataSourceConfig(){
        return new ProdDataSourceConfig();
    }
}
