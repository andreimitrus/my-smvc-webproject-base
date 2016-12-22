package com.my.project.support;

/**
 * @author amitrus
 */
public class ApplicationConstants {
    private static class ApplicationMessagesConstantsInstanceHolder {
        public static final ApplicationConstants INSTANCE = new ApplicationConstants();
    }

    public static ApplicationConstants getInstance() {
        return ApplicationMessagesConstantsInstanceHolder.INSTANCE;
    }

/*  Left as example
    @Value("${exception.business.message}")
    public String businessExceptionMessage;
*/

    public static final String SYSTEM_EXCEPTION_MESSAGE = "exception.system.message";
}
