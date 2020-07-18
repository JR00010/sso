package com.xxl.sso.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * description: TODO
 * date: 2020/7/17 0017 下午 21:57
 *
 * @author : Administrator
 * @since : 1.0
 **/
@ConfigurationProperties(prefix = "springboot.xxl.sso")
public class XxlSsoProperties {
//    @Value("${xxl.sso.server}")
    private String xxlSsoServer;

//    @Value("${xxl.sso.logout.path}")
    private String xxlSsoLogoutPath;

//    @Value("${xxl-sso.excluded.paths}")
    private String xxlSsoExcludedPaths;

//    @Value("${xxl.sso.redis.address}")
    private String xxlSsoRedisAddress;

    public String getXxlSsoServer() {
        return xxlSsoServer;
    }

    public void setXxlSsoServer(String xxlSsoServer) {
        this.xxlSsoServer = xxlSsoServer;
    }

    public String getXxlSsoLogoutPath() {
        return xxlSsoLogoutPath;
    }

    public void setXxlSsoLogoutPath(String xxlSsoLogoutPath) {
        this.xxlSsoLogoutPath = xxlSsoLogoutPath;
    }

    public String getXxlSsoExcludedPaths() {
        return xxlSsoExcludedPaths;
    }

    public void setXxlSsoExcludedPaths(String xxlSsoExcludedPaths) {
        this.xxlSsoExcludedPaths = xxlSsoExcludedPaths;
    }

    public String getXxlSsoRedisAddress() {
        return xxlSsoRedisAddress;
    }

    public void setXxlSsoRedisAddress(String xxlSsoRedisAddress) {
        this.xxlSsoRedisAddress = xxlSsoRedisAddress;
    }
}
