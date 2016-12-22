package com.my.project.domain.vo;

import java.io.Serializable;

/**
 * @author amitrus
 */
public class BusinessMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String message;

    private String[] params;

    public BusinessMessage(String message) {
        this.message = message;
    }


    public BusinessMessage(String message, String... params) {
        this.message = message;
        this.params = params;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    public boolean equals(Object bm){
        boolean result = false;
        if (bm instanceof BusinessMessage) {
            BusinessMessage obm = (BusinessMessage) bm;
            result = (this.message != null && this.message.equals(obm.getMessage())) || (this.message == null && obm.getMessage() == null);
            if (this.params != null && obm.getParams() != null) {
                result = result && (this.params.length == obm.getParams().length);
                if (result) {
                    for (int i = 0; i < this.params.length; i++) {
                        if (this.params[i] != null) {
                            result = result && (this.params[i].equals(obm.getParams()[i]));
                        } else {
                            result = result && (this.params[i] == null && obm.getParams()[i] == null);
                        }
                    }
                }
            } else {
                result = result && (this.params == null && obm.getParams() == null);
            }
        }
        return result;
    }
}