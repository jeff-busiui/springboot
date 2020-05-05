package com.atguigu.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author sunbaojin
 * @date 2020/5/5 8:46
 */
@ConfigurationProperties(prefix = "atguigu.myauto")
public class MyAutoProperties {

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getEndfix() {
        return endfix;
    }

    public void setEndfix(String endfix) {
        this.endfix = endfix;
    }

    /**
     * 前缀
     */
    private String prefix;

    /**
     * 后缀
     */
    private String endfix;
}
