package com.xcelevate.exercise1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("exercise1-beans.xml");

        NotificationService service = context.getBean("notificationService", NotificationService.class);
        service.notifyUser("user@xcelevate.com", "Welcome to Spring Training!");

        ((ClassPathXmlApplicationContext) context).close();
    }
}