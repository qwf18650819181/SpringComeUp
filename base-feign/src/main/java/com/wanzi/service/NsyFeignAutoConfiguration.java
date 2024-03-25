//package com.wanzi.service;
//
//import com.wanzi.service.coder.CommonFeignRequestInterceptor;
//import com.wanzi.service.coder.FeignErrorDecoder;
//import com.wanzi.service.coder.FeignRequestInterceptor;
//import com.wanzi.service.ext.NsySentinelFeign;
//import feign.Feign;
//import feign.RequestInterceptor;
//import org.springframework.boot.autoconfigure.AutoConfigureBefore;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//
///**
// * 功能描述:
// *
// * @author: qiu wanzi
// * @date: 2024年3月22日 0022
// * @version: 1.0
// */
//@Configuration(
//        proxyBeanMethods = false
//)
//@AutoConfigureBefore({SentinelFeignAutoConfiguration.class})
//public class NsyFeignAutoConfiguration {
//    public NsyFeignAutoConfiguration() {
//    }
//
//    @Bean
//    @Scope("prototype")
//    @ConditionalOnMissingBean
//    @ConditionalOnProperty(
//            name = {"feign.sentinel.enabled"}
//    )
//    public Feign.Builder feignSentinelBuilder() {
//        return NsySentinelFeign.builder();
//    }
//
//    @Bean
//    @ConditionalOnBean({LoginInfoService.class})
//    public RequestInterceptor requestInterceptor() {
//        return new FeignRequestInterceptor();
//    }
//
//    @Bean
//    @ConditionalOnMissingBean({LoginInfoService.class})
//    public RequestInterceptor commonFeignRequestInterceptor() {
//        return new CommonFeignRequestInterceptor();
//    }
//
//    @Bean
//    public FeignErrorDecoder feignErrorDecoder() {
//        return new FeignErrorDecoder();
//    }
//}
