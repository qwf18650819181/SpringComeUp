//package com.wanzi.service.ext;
//
//import feign.Feign;
//import feign.InvocationHandlerFactory;
//import feign.MethodMetadata;
//import feign.Target;
//import feign.Util;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cloud.openfeign.FallbackFactory;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
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
//public class NsySentinelInvocationHandler implements InvocationHandler {
//    public static final String EQUALS = "equals";
//    public static final String HASH_CODE = "hashCode";
//    public static final String TO_STRING = "toString";
//    private static final Logger LOGGER = LoggerFactory.getLogger(NsySentinelInvocationHandler.class);
//    private final Target<?> target;
//    private final Map<Method, InvocationHandlerFactory.MethodHandler> dispatch;
//    private FallbackFactory fallbackFactory;
//    private Map<Method, Method> fallbackMethodMap;
//
//    NsySentinelInvocationHandler(Target<?> target, Map<Method, InvocationHandlerFactory.MethodHandler> dispatch, FallbackFactory fallbackFactory) {
//        this.target = (Target) Util.checkNotNull(target, "target", new Object[0]);
//        this.dispatch = (Map)Util.checkNotNull(dispatch, "dispatch", new Object[0]);
//        this.fallbackFactory = fallbackFactory;
//        this.fallbackMethodMap = toFallbackMethod(dispatch);
//    }
//
//    NsySentinelInvocationHandler(Target<?> target, Map<Method, InvocationHandlerFactory.MethodHandler> dispatch) {
//        this.target = (Target)Util.checkNotNull(target, "target", new Object[0]);
//        this.dispatch = (Map)Util.checkNotNull(dispatch, "dispatch", new Object[0]);
//    }
//
//    static Map<Method, Method> toFallbackMethod(Map<Method, InvocationHandlerFactory.MethodHandler> dispatch) {
//        Map<Method, Method> result = new LinkedHashMap();
//        Iterator var2 = dispatch.keySet().iterator();
//
//        while(var2.hasNext()) {
//            Method method = (Method)var2.next();
//            method.setAccessible(true);
//            result.put(method, method);
//        }
//
//        return result;
//    }
//
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        if ("equals".equals(method.getName())) {
//            try {
//                Object otherHandler = args.length > 0 && args[0] != null ? Proxy.getInvocationHandler(args[0]) : null;
//                return this.equals(otherHandler);
//            } catch (IllegalArgumentException var18) {
//                return false;
//            }
//        } else if ("hashCode".equals(method.getName())) {
//            return this.hashCode();
//        } else if ("toString".equals(method.getName())) {
//            return this.toString();
//        } else {
//            Object result = null;
//            InvocationHandlerFactory.MethodHandler methodHandler = (InvocationHandlerFactory.MethodHandler)this.dispatch.get(method);
//            Entry entry = null;
//            if (this.target instanceof Target.HardCodedTarget) {
//                Target.HardCodedTarget hardCodedTarget = (Target.HardCodedTarget)this.target;
//                MethodMetadata methodMetadata = (MethodMetadata)SentinelContractHolder.METADATA_MAP.get(hardCodedTarget.type().getName() + Feign.configKey(hardCodedTarget.type(), method));
//                if (methodMetadata != null) {
//                    String resourceName = methodMetadata.template().method().toUpperCase() + ":" + hardCodedTarget.url() + methodMetadata.template().path();
//                    ContextUtil.enter(resourceName);
//                    entry = SphU.entry(resourceName, EntryType.OUT, 1, args);
//                }
//            }
//
//            Object var24;
//            try {
//                Throwable ex;
//                try {
//                    result = methodHandler.invoke(args);
//                    return result;
//                } catch (Throwable var19) {
//                    ex = var19;
//                    if (!BlockException.isBlockException(var19)) {
//                        Tracer.trace(var19);
//                    }
//                }
//
//                if (this.fallbackFactory == null) {
//                    throw var19;
//                }
//
//                try {
//                    Object fallbackResult = ((Method)this.fallbackMethodMap.get(method)).invoke(this.fallbackFactory.create(ex), args);
//                    var24 = fallbackResult;
//                } catch (IllegalAccessException var16) {
//                    throw new AssertionError(var16);
//                } catch (InvocationTargetException var17) {
//                    throw new AssertionError(var17.getCause());
//                }
//            } finally {
//                if (entry != null) {
//                    entry.exit(1, args);
//                }
//
//                ContextUtil.exit();
//            }
//
//            return var24;
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj instanceof SentinelInvocationHandler) {
//            NsySentinelInvocationHandler other = (NsySentinelInvocationHandler)obj;
//            return this.target.equals(other.target);
//        } else {
//            return false;
//        }
//    }
//
//    public int hashCode() {
//        return this.target.hashCode();
//    }
//
//    public String toString() {
//        return this.target.toString();
//    }
//}
//
