package com.pingan.conf;
/**
 * Created by dafei on 2020/4/05
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan( basePackages = "{com.pingan..*.*}")
public class AppConfig {
    private String env;
    private String host;
}
