package org.wlgzs.hospitalmanage.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:胡亚星
 * @createTime 2018-08-20 10:01
 * @description:
 **/
@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean filterDemoRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //注入过滤器
        registration.setFilter(new LoginFilter());
        //拦截规则
        registration.addUrlPatterns("/check/*");
        registration.addUrlPatterns("/disease/*");
        registration.addUrlPatterns("/attribute/*");
        registration.addUrlPatterns("/StorageRecord/*");
        registration.addUrlPatterns("/DrugInventory/*");
        registration.addUrlPatterns("/drug/*");
        registration.addUrlPatterns("/note/*");
        registration.addUrlPatterns("/patient/*");
        registration.addUrlPatterns("/prescription/*");
        registration.addUrlPatterns("/treatment/*");
        registration.addUrlPatterns("/toHome");
        registration.addUrlPatterns("/toHospital");
        //过滤器名称
        registration.setName("LoginFilter");
        //是否自动注册 false 取消Filter的自动注册
        registration.setEnabled(true);
        //过滤器顺序
        registration.setOrder(Integer.MAX_VALUE - 1);
        return registration;
    }

}
