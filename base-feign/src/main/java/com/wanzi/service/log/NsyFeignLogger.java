package com.wanzi.service.log;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import feign.Logger;
import feign.Request;
import feign.Response;
import feign.Util;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 功能描述:
 *
 * @author: qiu wanzi
 * @date: 2024年3月22日 0022
 * @version: 1.0
 */

public class NsyFeignLogger extends Logger {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(NsyFeignLogger.class);

    public NsyFeignLogger() {
    }

    protected void log(String configKey, String format, Object... args) {
    }

    protected void logRequest(String configKey, Logger.Level logLevel, Request request) {
        String traceId = MDC.get("traceId");
        if (StrUtil.isEmpty(traceId)) {
            traceId = IdUtil.fastSimpleUUID();
            MDC.put("traceId", traceId);
        }

        Request.HttpMethod httpMethod = request.httpMethod();
        String url = request.url();
        String param = " ";
        if (request.body() != null) {
            param = new String(request.body(), Util.UTF_8);
        }

        if (param.length() > 1000) {
            param = param.substring(0, 1000);
        }

        LOGGER.info(" [{}]" + configKey + "---> {} url:{}, param:{}.", new Object[]{traceId, httpMethod, url, param});
    }

    protected void logRetry(String configKey, Logger.Level logLevel) {
        String traceId = MDC.get("traceId");
        LOGGER.info(" [{}]" + configKey + " ---> RETRYING", traceId);
    }

    protected Response logAndRebufferResponse(String configKey, Logger.Level logLevel, Response response, long elapsedTime) throws IOException {
        String traceId = MDC.get("traceId");
        String result = "";

        Response var9;
        try {
            if (response.body() == null) {
                Response var13 = response;
                return var13;
            }

            byte[] bodyData = Util.toByteArray(response.body().asInputStream());
            result = Util.decodeOrDefault(bodyData, Util.UTF_8, "Binary data");
            var9 = response.toBuilder().body(bodyData).build();
        } finally {
            if (result.length() > 1000) {
                result = result.substring(0, 1000);
            }

            if (response.status() == HttpStatus.OK.value()) {
                LOGGER.info(" [{}]" + configKey + "---> costTime:{}ms,result:{}.", new Object[]{traceId, elapsedTime, result});
            } else {
                LOGGER.error(" [{}]" + configKey + "---> costTime:{}ms,status:{},result:{}.", new Object[]{traceId, elapsedTime, response.status(), result});
            }

        }

        return var9;
    }

    protected IOException logIOException(String configKey, Logger.Level logLevel, IOException ioe, long elapsedTime) {
        String traceId = MDC.get("traceId");
        LOGGER.error(" [{}]" + configKey + "---> costTime:{}ms,ERROR {}: {}", new Object[]{traceId, elapsedTime, ioe.getClass().getSimpleName(), ioe.getMessage()});
        StringWriter sw = new StringWriter();
        ioe.printStackTrace(new PrintWriter(sw));
        LOGGER.error(" [{}]" + configKey + "{}", traceId, sw.toString());
        return ioe;
    }
}
