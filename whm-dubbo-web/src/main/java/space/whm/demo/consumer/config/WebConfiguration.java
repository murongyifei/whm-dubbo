package space.whm.demo.consumer.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

//import com.sxy618.log.traceid.webfilter.TraceIdFilter;

@Configuration
public class WebConfiguration {
//    @Bean
//    public FilterRegistrationBean<TraceIdFilter> traceIdFilter() {
//	    FilterRegistrationBean<TraceIdFilter> registration = new FilterRegistrationBean<TraceIdFilter>();
//	    registration.setFilter(new TraceIdFilter());
//	    //registration.addInitParameter(TraceIdFilter.INIT_PARAMETER_NO_TRACEID_PATHS, "");//不需要traceid的请求的path
//	    registration.addUrlPatterns("/*");
//	    registration.setName("traceIdFilter");
//	    registration.setOrder(Ordered.HIGHEST_PRECEDENCE);//建议配为最选执行的过滤器
//	    return registration;
//    }
}