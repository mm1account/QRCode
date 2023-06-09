//package com.example.demo.config;
//
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.*;
//
//
//@Configuration
//@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
//public class WebConfiguration extends WebMvcConfigurationSupport {
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        System.out.println("跨域处理");
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//        super.addResourceHandlers(registry);
//    }
//
//    /**
//     * CROS跨域的处理
//     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH")
//                .allowCredentials(true).maxAge(3600);
//    }
//}