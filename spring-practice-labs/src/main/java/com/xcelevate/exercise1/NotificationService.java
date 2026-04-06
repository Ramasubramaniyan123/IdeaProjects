package com.xcelevate.exercise1;


public class NotificationService {
    private EmailService emailService;

    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void notifyUser(String email, String notification) {
        System.out.println("NotificationService: Processing notification...");
        emailService.sendEmail(email, notification);
    }
}