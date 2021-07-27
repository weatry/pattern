package com.github.budwing.pattern.alarm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AlarmExecutor {
	AlarmMessage data = new AlarmMessage(new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒"));
	private String smsURL;
	private String smtpHost;
	private String emailUser;
	private String emailPassword;

	private int smsRetryTimes = 3;
	private int phoneRetryTimes = 3;
	private int emailRetryTimes = 3;

	private Map<String, String> voiceMapping = new HashMap();

	public String getDesease() {
		return data.getDesease();
	}

	public void setDesease(String desease) {
		this.data.setDesease(desease);
	}

	public int getDuration() {
		return data.getDuration();
	}

	public void setDuration(int duration) {
		this.data.setDuration(duration);
	}

	public int getPatientNumber() {
		return data.getPatientNumber();
	}

	public void setPatientNumber(int patientNumber) {
		this.data.setPatientNumber(patientNumber);
	}

	public String getDistrict() {
		return data.getDistrict();
	}

	public void setDistrict(String district) {
		this.data.setDistrict(district);
	}

	public Date getTime() {
		return data.getTime();
	}

	public void setTime(Date time) {
		this.data.setTime(time);
	}

	public Map<String, String> getVoiceMapping() {
		return voiceMapping;
	}

	public void setVoiceMapping(Map<String, String> voiceMapping) {
		this.voiceMapping = voiceMapping;
	}

	public String getSmsURL() {
		return smsURL;
	}

	public void setSmsURL(String smsURL) {
		this.smsURL = smsURL;
	}

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getEmailPassword() {
		return emailPassword;
	}

	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}

	public int getSmsRetryTimes() {
		return smsRetryTimes;
	}

	public void setSmsRetryTimes(int smsRetryTimes) {
		this.smsRetryTimes = smsRetryTimes;
	}

	public int getPhoneRetryTimes() {
		return phoneRetryTimes;
	}

	public void setPhoneRetryTimes(int phoneRetryTimes) {
		this.phoneRetryTimes = phoneRetryTimes;
	}

	public int getEmailRetryTimes() {
		return emailRetryTimes;
	}

	public void setEmailRetryTimes(int emailRetryTimes) {
		this.emailRetryTimes = emailRetryTimes;
	}

	public void log(Employee emp, int code, String msg, String state) {

	}

	public void log(List<Employee> emps, int code, String msg, String state) {
		for (Employee e : emps) {
			log(e, code, msg, state);
		}
	}

	public boolean sendMsg(List<Employee> contacts) {
		sendSMSMessage(contacts);

		sendEmailMessage(contacts);

		sendPhoneMessage(contacts);

		return false;
	}

	public void sendPhoneMessage(List<Employee> contacts) {
		// 打电话
		String phonecontent = data.buildPhoneMessage();

		String[] voiceFiles = new String[phonecontent.length()];
		for (int i = 0; i < phonecontent.length(); i++) {
			voiceFiles[i] = voiceMapping.get(phonecontent.charAt(i));
		}

		for (Employee e : contacts) {
			for (int i = 0; i < phoneRetryTimes; i++) {
				if (phone(e.getTelephone(), voiceFiles)) {
					log(e, 3, phonecontent.toString(), "success");
					break;
				}
			}
			log(e, 3, phonecontent.toString(), "failure");
		}
	}

	public void sendEmailMessage(List<Employee> contacts) {
		// 发送邮件
		String emailContent = data.buildEmailMessage();
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
				mailMsg.setSubject("群体性疾病预警");
				mailMsg.setContent(emailContent.toString(),
						"text/html;charset=utf-8");
				mailMsg.setRecipients(RecipientType.TO, address);

				Transport.send(mailMsg);
				log(contacts, 2, emailContent.toString(), "success");
				break;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				log(contacts, 2, emailContent.toString(), "failure");
			}
		}
	}

	public void sendSMSMessage(List<Employee> contacts) {
		String smscontent = data.buildSMSMessage();
		int index = 0;
		try {
			StringBuilder sb = new StringBuilder(smsURL);
			sb.append("?msg=")
					.append(URLEncoder.encode(smscontent.toString(), "utf-8"))
					.append("&contacts=");
			StringBuilder contactsStr = new StringBuilder();
			
			for (Employee e : contacts) {
				if (e.getMobile() != null && !e.getMobile().isEmpty()) {
					if (index > 0)
						contactsStr.append(",");
					contactsStr.append(e.getMobile());
					index++;
				}
			}
			sb.append(contactsStr);

			String smsResult = null;
			for (int i = 0; i < smsRetryTimes; i++) {
				URL url = new URL(sb.toString());
				HttpURLConnection conn = (HttpURLConnection) url
						.openConnection();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
				smsResult = reader.readLine();
				if (smsResult.equals("done")) {
					log(contacts, 1, smscontent.toString(), "success");
					break;
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log(contacts, 1, smscontent.toString(), "failure");
		}
	}

	public native boolean phone(String phoneNum, String[] voiceFiles);

	/*public static void main(String[] args) {
		Alarm a = new Alarm();
		a.setDesease("伤寒");
		a.setDistrict("山东省潍坊市");
		a.setDuration(5);
		a.setPatientNumber(38);
		a.setTime(new Date());

		a.setSmsURL("http://www.sina.com.cn");

		a.sendMsg(new ArrayList());
	}*/
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
