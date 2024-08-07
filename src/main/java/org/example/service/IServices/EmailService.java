package org.example.service.IServices;

public interface EmailService {

	 void sendOrderConfirmationEmail(String to, String subject, String text);
}
