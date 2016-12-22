package com.my.project.exception;

import com.my.project.domain.vo.BusinessMessage;

/**
 * @author amitrus
 */
public class SystemException extends RuntimeException {
    private BusinessMessage businessMessage;
    private Integer code;

    public SystemException() {
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemException(Throwable cause) {
        super(cause);
    }

    public SystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public SystemException(BusinessMessage m) {
        super();
        this.setBusinessMessage(m);
    }

    public SystemException(BusinessMessage m, Integer code) {
        super();
        this.setBusinessMessage(m);
        this.code = code;
    }

    public SystemException(Integer code) {
        super();
        this.code = code;
    }

    public BusinessMessage getBusinessMessage() {
        return businessMessage;
    }

    public void setBusinessMessage(BusinessMessage businessMessage) {
        this.businessMessage = businessMessage;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
