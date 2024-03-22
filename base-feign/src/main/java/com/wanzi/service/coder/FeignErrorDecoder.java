package com.wanzi.service.coder;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.wanzi.service.exception.RemoteBusinessException;
import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * 功能描述:
 *
 * @author: qiu wanzi
 * @date: 2024年3月22日 0022
 * @version: 1.0
 */

@Configuration
public class FeignErrorDecoder implements ErrorDecoder {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeignErrorDecoder.class);

    public FeignErrorDecoder() {
    }

    public Exception decode(String methodKey, Response response) {
        String traceId = MDC.get("traceId");
        if (response.status() == 200) {
            return FeignException.errorStatus(methodKey, response);
        } else {
            String errorMsg = "";
            String businessCode = "";
            HashMap respondMap = new HashMap(20);

            try {
                if (response.body() != null) {
                    errorMsg = response.body().toString();
                    respondMap = JSONUtil.toBean(errorMsg, HashMap.class);
                }
            } catch (Exception var8) {
                LOGGER.info(" [{}] feign.IOException", traceId, var8);
                throw new RemoteBusinessException("feign.IOException", var8.getMessage());
            }

            businessCode = (String)respondMap.get("businessCode");
            if (StrUtil.isNotBlank(businessCode)) {
                String msg = (String)respondMap.get("message");
                if (StrUtil.isNotBlank(msg)) {
                    errorMsg = msg;
                }

                throw new RemoteBusinessException(businessCode, errorMsg);
            } else {
                throw new RemoteBusinessException("systemError:" + response.status(), errorMsg);
            }
        }
    }
}

