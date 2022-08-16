package com.mozahidone.template;

import com.mozahidone.enums.TemplateCounter;

public class MessageTemplate {
    //private static final String customerName = "Mr. John";
    private static final String employeeName = "Mozahid";
    public static String getMessage(String customerName, Integer counter) {
        if (counter == TemplateCounter.FIRST.getValue()) {
            return getFirstTemplate(customerName, employeeName);
        } if (counter == TemplateCounter.SECOND.getValue()) {
            return getSecondTemplate(customerName, employeeName);
        } if (counter == TemplateCounter.THIRD.getValue()) {
            return getThirdTemplate(customerName, employeeName);
        } if (counter == TemplateCounter.FOURTH.getValue()) {
            return getFourthTemplate(customerName, employeeName);
        }
        return defaultTemplate(customerName, employeeName);
    }

    private static String defaultTemplate(String customerName, String employeeName) {
        String message = " Hi " + customerName + ", <br>I hope your phone no. is still the same. Talk to you soon. <br>" + employeeName;
        return message;
    }

    private static String getFirstTemplate(String customerName, String employeeName) {
        String message = " Hi " + customerName + ", <br>This is first message. I am trying to reach you. <br>" + employeeName;
        return message;
    }

    private static String getSecondTemplate(String customerName, String employeeName) {
        String message = " Hi " + customerName + ", <br>This is second message. I am trying to reach you. <br>" + employeeName;
        return message;
    }

    private static String getThirdTemplate(String customerName, String employeeName) {
        String message = " Hi " + customerName + ", <br>This is third message. I am trying to reach you. <br>" + employeeName;
        return message;
    }

    private static String getFourthTemplate(String customerName, String employeeName) {
        String message = " Hi " + customerName + ", <br>Talk to you soon. Have a nice day! <br>" + employeeName;
        return message;
    }

}
