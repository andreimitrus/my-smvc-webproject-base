package com.my.project.support.spring.mvc;

import com.my.project.exception.BusinessException;
import com.my.project.exception.SystemException;
import com.my.project.support.ApplicationConstants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author amitrus
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    private static final Logger LOGGER = Logger.getLogger(GlobalDefaultExceptionHandler.class);

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBusinessException(BusinessException ex) {
        LOGGER.debug(ex);

        if (ex.getBusinessMessage() != null) {
            return messageSource.getMessage(ex.getBusinessMessage().getMessage(), ex.getBusinessMessage().getParams(), null);
        }

        return messageSource.getMessage("exception.business.generic.message", null, null) + " " + ex.getMessage();
    }

    @ExceptionHandler(SystemException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleSystemException(SystemException ex) {
        LOGGER.debug(ex);

        if (ex.getBusinessMessage() != null) {
            return messageSource.getMessage(ex.getBusinessMessage().getMessage(), ex.getBusinessMessage().getParams(), null);
        }

        return messageSource.getMessage("exception.system.generic.message", null, null) + " " + ex.getMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception e) {
        LOGGER.debug(e);
        return messageSource.getMessage(ApplicationConstants.SYSTEM_EXCEPTION_MESSAGE, null, null) + " " + e.getMessage();
    }
}
