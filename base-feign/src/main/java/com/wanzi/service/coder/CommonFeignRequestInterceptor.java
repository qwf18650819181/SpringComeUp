package com.wanzi.service.coder;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.MDC;

/**
 * 功能描述:
 *
 * @author: qiu wanzi
 * @date: 2024年3月22日 0022
 * @version: 1.0
 */
public class CommonFeignRequestInterceptor implements RequestInterceptor {
    public CommonFeignRequestInterceptor() {
    }

    public void apply(RequestTemplate template) {
        String traceId = MDC.get("traceId");
        String location = MDC.get("location");
        template.header("location", new String[]{location});
        template.header("traceId", new String[]{traceId});
    }
}
