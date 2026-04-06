package com.learning.spring.basic.setterBased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("setterbeans.xml");
        Car car = applicationContext.getBean("car", Car.class);
        car.drive();
    }
}
