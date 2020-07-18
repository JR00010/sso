package com.xxl.sso.config;


import com.xxl.sso.core.conf.Conf;
import com.xxl.sso.core.filter.XxlSsoWebFilter;
import com.xxl.sso.core.util.JedisUtil;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuxueli 2018-11-15
 */
@Configuration
@EnableConfigurationProperties(XxlSsoProperties.class)
@ConditionalOnClass({JedisUtil.class,XxlSsoWebFilter.class,Conf.class})
public class XxlSsoConfig implements DisposableBean {





    @Bean
    public FilterRegistrationBean xxlSsoFilterRegistration(XxlSsoProperties xxlSsoProperties) {

        // xxl-sso, redis init
        JedisUtil.init(xxlSsoProperties.getXxlSsoRedisAddress());

        // xxl-sso, filter init
        FilterRegistrationBean registration = new FilterRegistrationBean();

        registration.setName("XxlSsoWebFilter");
        registration.setOrder(1);
        registration.addUrlPatterns("/*");
        registration.setFilter(new XxlSsoWebFilter());
        registration.addInitParameter(Conf.SSO_SERVER,xxlSsoProperties.getXxlSsoServer());
        registration.addInitParameter(Conf.SSO_LOGOUT_PATH,xxlSsoProperties.getXxlSsoLogoutPath() );
        registration.addInitParameter(Conf.SSO_EXCLUDED_PATHS,xxlSsoProperties.getXxlSsoExcludedPaths());

        return registration;
    }

    @Override
    public void destroy() throws Exception {

        // xxl-sso, redis close
        JedisUtil.close();
    }

}
