package com.wanzi.service.coder;

import cn.hutool.core.util.StrUtil;
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

public class FeignRequestInterceptor implements RequestInterceptor {

    public FeignRequestInterceptor() {
    }

    public void apply(RequestTemplate template) {
        String traceId = MDC.get("traceId");
        String location = MDC.get("location");
        template.header("location", new String[]{location});
        template.header("traceId", new String[]{traceId});
        String httpFlag = MDC.get("httpFlag");
//        if (StrUtil.isNotBlank(httpFlag)) {
//            template.header("real-name", new String[]{EncodingUtils.url(this.loginInfoService.getName())});
//            template.header("user-name", new String[]{EncodingUtils.url(this.loginInfoService.getUserName())});
//            template.header("user-code", new String[]{this.loginInfoService.getUserCode()});
//            template.header("user-id", new String[]{String.valueOf(this.loginInfoService.getUserId())});
//            template.header("is-admin", new String[]{String.valueOf(this.loginInfoService.isAdmin())});
//        } else {
//            template.header("real-name", new String[]{EncodingUtils.url(this.loginInfoService.getCurName())});
//        }

    }
}

