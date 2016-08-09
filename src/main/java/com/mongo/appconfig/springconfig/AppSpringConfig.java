package com.mongo.appconfig.springconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

@EnableWebMvc
@ComponentScan(basePackages = "com.mongo.app")
@Configuration
public class AppSpringConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		registry.addInterceptor(buildWebContentInterceptor());
		super.addInterceptors(registry);
	}

	private HandlerInterceptor buildWebContentInterceptor() {
		final WebContentInterceptor interceptor = new WebContentInterceptor();
		interceptor.setCacheSeconds(0);
		interceptor.setUseExpiresHeader(Boolean.TRUE);
		interceptor.setUseCacheControlHeader(Boolean.TRUE);
		interceptor.setUseCacheControlNoStore(Boolean.TRUE);
		return interceptor;
	}
}
