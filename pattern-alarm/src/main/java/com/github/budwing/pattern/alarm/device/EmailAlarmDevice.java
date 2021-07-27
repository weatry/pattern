package com.github.budwing.pattern.alarm.device;

import com.github.budwing.pattern.alarm.Employee;

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class EmailAlarmDevice extends AlarmDevice {
	private String smtpHost;
	private String emailUser;
	private String emailPassword;
	private int emailRetryTimes = 3;

	public boolean sendMessage(String msg, List<Employee> contacts) {

		Properties prop = new Properties();
		prop.setProperty("mail.smtp.host", smtpHost);
		prop.setProperty("mail.smtp.user", emailUser);
		prop.setProperty("mail.smtp.auth", "true");
		Session session = Session.getInstance(prop, new SmtpUPAuth(emailUser,
				emailPassword));
		InternetAddress[] address = new InternetAddress[contacts.size()];
		int index = 0;
		for (Employee e : contacts) {
			try {
				address[index] = new InternetAddress(e.getEmail());
				index++;
			} catch (AddressException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		for (int i = 0; i < emailRetryTimes; i++) {
			try {
				Message mailMsg = new MimeMessage(session);
				mailMsg.setFrom(new InternetAddress(emailUser));
				mailMsg.setSubject("ÈºÌåÐÔ¼²²¡Ô¤¾¯");
				mailMsg.setContent(msg,
						"text/html;charset=utf-8");
				mailMsg.setRecipients(RecipientType.TO, address);

				Transport.send(mailMsg);
				log(contacts, 2, msg, "success");
				break;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				log(contacts, 2, msg, "failure");
			}
		}

		return true;
	}

}

class SmtpUPAuth extends Authenticator {
	private String username;
	private String password;

	public SmtpUPAuth(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public PasswordAuthentication getPasswordAuthentication() {
		// TODO Auto-generated method stub
		return new PasswordAuthentication(username, password);
	}

}
