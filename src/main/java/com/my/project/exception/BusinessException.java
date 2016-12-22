package com.my.project.exception;

import com.my.project.domain.vo.BusinessMessage;

/**
 * @author amitrus
 */
public class BusinessException extends Exception {
    private BusinessMessage businessMessage;
    private Integer code;

    public BusinessException() {
        super();
    }
    public BusinessException(String arg0) {
        super(arg0);
    }
    public BusinessException(Throwable cause) {
        super(cause);
    }
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(BusinessMessage m) {
        super();
        this.setBusinessMessage(m);
    }

    public BusinessException(BusinessMessage m, Integer code) {
        super();
        this.setBusinessMessage(m);
        this.code = code;
    }

    public BusinessException(Integer code) {
        super();
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BusinessMessage getBusinessMessage() {
        return businessMessage;
    }

    public void setBusinessMessage(BusinessMessage businessMessage) {
        this.businessMessage = businessMessage;
    }
}