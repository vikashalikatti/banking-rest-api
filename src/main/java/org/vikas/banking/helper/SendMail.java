package org.vikas.banking.helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.vikas.banking.dto.Customer;

import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class SendMail {
	@Autowired
	JavaMailSender mailSender;

	@Autowired
	Configuration configuration;

	public boolean sendLink(Customer customer,String token) throws Exception {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

		try {
			helper.setFrom("E-kart <gangsteryt111@gmail.com>");
			helper.setTo(customer.getEmail());
			helper.setSubject("Verify Email for Account Creation");

			Template template = configuration.getTemplate("customer-sendLink.ftl");
			Map<String, Object> model = new HashMap<>();
			model.put("merchant", customer);
//			model.put("otp", customer.getOtp());
			String genderPrefix = "Mr.";
			if ("female".equalsIgnoreCase(customer.getGender())) {
				genderPrefix = "Ms.";
			} else {
				genderPrefix = "Mr.";
			}
			model.put("genderPrefix", genderPrefix);
			String email = customer.getEmail();
			model.put("email", email);
			model.put("customer", customer);
			LocalDateTime otpExpirationTime = LocalDateTime.now().plusMinutes(5);

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String formattedOTPExpirationTime = otpExpirationTime.format(formatter);
			model.put("formattedOTPExpirationTime", formattedOTPExpirationTime);
			System.out.println("Formatted OTP Expiration Time: " + formattedOTPExpirationTime);
			model.put("token", token);
			String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
      
			helper.setText(content, true);
			mailSender.send(mimeMessage);
			return true;

		} catch (MessagingException e) {
			return false;

		}
	}
}
