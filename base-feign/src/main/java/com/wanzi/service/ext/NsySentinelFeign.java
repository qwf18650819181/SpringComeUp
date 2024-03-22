//package com.wanzi.service.ext;
//
//import cn.hutool.core.util.StrUtil;
//import feign.Contract;
//import feign.Feign;
//import feign.InvocationHandlerFactory;
//import feign.Target;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.BeansException;
//import org.springframework.cloud.openfeign.FallbackFactory;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.core.annotation.AnnotationUtils;
//import org.springframework.util.ReflectionUtils;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.util.Map;
//
///**
// * 功能描述:
// *
// * @author: qiu wanzi
// * @date: 2024年3月22日 0022
// * @version: 1.0
// */
//
//public final class NsySentinelFeign {
//    private static final Logger LOGGER = LoggerFactory.getLogger(NsySentinelFeign.class);
//
//    private NsySentinelFeign() {
//    }
//
//    public static Builder builder() {
//        return new Builder();
//    }
//
//    public static final class Builder extends Feign.Builder implements ApplicationContextAware {
//        private Contract contract = new Contract.Default();
//        private ApplicationContext applicationContext;
//        private feigncontext feignContext;
//
//        public Builder() {
//        }
//
//        public Feign.Builder invocationHandlerFactory(InvocationHandlerFactory invocationHandlerFactory) {
//            throw new UnsupportedOperationException();
//        }
//
//        public Builder contract(Contract contract) {
//            this.contract = contract;
//            return this;
//        }
//
//        public Feign build() {
//            super.invocationHandlerFactory(new InvocationHandlerFactory() {
//                public InvocationHandler create(Target target, Map<Method, MethodHandler> dispatch) {
//                    FeignClient feignClient = (FeignClient) AnnotationUtils.findAnnotation(target.type(), FeignClient.class);
//
//                    assert feignClient != null;
//
//                    Class<?> fallback = feignClient.fallback();
//                    Class<?> fallbackFactoryClass = feignClient.fallbackFactory();
//                    String beanName = feignClient.contextId();
//                    if (StrUtil.isNotBlank(beanName)) {
//                        beanName = feignClient.name();
//                    }
//
//                    if (Void.TYPE != fallback) {
//                        Object fallbackInstance = this.getFromContext(beanName, "fallback", fallback, target.type());
//                        FallbackFactory fallbackFactory = new FallbackFactory.Default(fallbackInstance);
//                        return new NsySentinelInvocationHandler(target, dispatch, fallbackFactory);
//                    } else if (Void.TYPE != fallbackFactoryClass) {
//                        FallbackFactory fallbackFactoryInstance = (FallbackFactory)this.getFromContext(beanName, "fallbackFactory", fallbackFactoryClass, FallbackFactory.class);
//                        return new NsySentinelInvocationHandler(target, dispatch, fallbackFactoryInstance);
//                    } else {
//                        return new NsySentinelInvocationHandler(target, dispatch);
//                    }
//                }
//
//                private Object getFromContext(String name, String type, Class fallbackType, Class targetType) {
//                    Object fallbackInstance = Builder.this.feignContext.getInstance(name, fallbackType);
//                    if (fallbackInstance == null) {
//                        throw new IllegalStateException(String.format("No %s instance of type %s found for feign client %s", type, fallbackType, name));
//                    } else if (targetType.isAssignableFrom(fallbackType)) {
//                        return fallbackInstance;
//                    } else {
//                        throw new IllegalStateException(String.format("Incompatible %s instance. Fallback/fallbackFactory of type %s is not assignable to %s for feign client %s", type, fallbackType, targetType, name));
//                    }
//                }
//            });
//            super.contract(new SentinelContractHolder(this.contract));
//            return super.build();
//        }
//
//        private Object getFieldValue(Object instance, String fieldName) {
//            Field field = ReflectionUtils.findField(instance.getClass(), fieldName);
//
//            assert field != null;
//
//            field.setAccessible(true);
//
//            try {
//                return field.get(instance);
//            } catch (IllegalAccessException var5) {
//                NsySentinelFeign.LOGGER.error("getFieldValue error:", var5.getMessage());
//                return null;
//            }
//        }
//
//        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//            this.applicationContext = applicationContext;
//            this.feignContext = (FeignContext)this.applicationContext.getBean(FeignContext.class);
//        }
//    }
//}
//
