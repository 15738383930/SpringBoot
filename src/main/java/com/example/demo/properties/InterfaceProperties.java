package com.example.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.lang.annotation.RetentionPolicy;

/**
 * @Author zhou
 * @Date 2019/8/2 16:08
 */
@ConfigurationProperties(prefix = "zh.interface")
public class InterfaceProperties {

    private String name;

    private RetentionPolicy retention;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RetentionPolicy getRetention() {
        return retention;
    }

    public void setRetention(RetentionPolicy retention) {
        this.retention = retention;
    }
}
