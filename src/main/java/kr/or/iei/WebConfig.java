package kr.or.iei;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;


//스프링부트 설정파일
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	@Value("${file.root}")
	private String root;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
			.addResourceHandler("/**")		 //별 두개 : 안에 폴더가 몇개있든 모두
			.addResourceLocations("classpath:/templates", "classpath:/static/");
		registry
			.addResourceHandler("/board/**")
			.addResourceLocations("file:///"+root+"/board/");
	}
	/*
	@Bean
	public BCryptPasswordEncoder bCrype() {
		return new BCryptPasswordEncoder();
	}
	*/
	
}
