package com.wanzi.service.exception;

/**
 * 功能描述:
 *
 * @author: qiu wanzi
 * @date: 2024年3月22日 0022
 * @version: 1.0
 */

public class RemoteBusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final String businessCode;

    public RemoteBusinessException(String businessCode, String message) {
        super(message);
        this.businessCode = businessCode;
    }

    public RemoteBusinessException(String businessCode, Throwable cause) {
        super(cause);
        this.businessCode = businessCode;
    }

    public RemoteBusinessException(String businessCode, String message, Throwable cause) {
        super(message, cause);
        this.businessCode = businessCode;
    }

    public RemoteBusinessException(String businessCode, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.businessCode = businessCode;
    }

    public String getBusinessCode() {
        return this.businessCode;
    }
}
