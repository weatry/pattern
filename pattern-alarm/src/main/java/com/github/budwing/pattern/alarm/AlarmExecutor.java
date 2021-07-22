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
	private String desease;
	private int duration;
	private int patientNumber;
	private String district;
	private Date time;

	private String smsURL;
	private String smtpHost;
	private String emailUser;
	private String emailPassword;

	private int smsRetryTimes = 3;
	private int phoneRetryTimes = 3;
	private int emailRetryTimes = 3;

	private Map<String, String> voiceMapping = new HashMap();
	private SimpleDateFormat timeFormat = new SimpleDateFormat(
			"yyyy年MM月dd日HH时mm分ss秒");

	public String getDesease() {
		return desease;
	}

	public void setDesease(String desease) {
		this.desease = desease;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(int patientNumber) {
		this.patientNumber = patientNumber;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
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
		String phonecontent = buildPhoneMessage();

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

	public String buildPhoneMessage() {
		StringBuilder phonecontent = new StringBuilder("尊敬的领导");
		phonecontent.append("  截止到").append(timeFormat.format(time))
				.append(" 在").append(district).append(duration).append("天内发生了")
				.append(patientNumber).append("起").append(desease)
				.append("感染病例   该数据已超过历史同期水平  请注意防范疫情流行  ");
		return phonecontent.toString();
	}

	public void sendEmailMessage(List<Employee> contacts) {
		// 发送邮件
		String emailContent = buildEmailMessage();
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

	public String buildEmailMessage() {
		StringBuilder emailContent = new StringBuilder("尊敬的领导：<br/><br/>");
		emailContent.append("&nbsp;&nbsp;&nbsp;&nbsp;<font color=red>")
				.append("截止到").append(timeFormat.format(time)).append("，<b>在")
				.append(district).append(duration).append("天内发生了")
				.append(patientNumber).append("起").append(desease)
				.append("感染病例</b>。该数据已超过历史同期水平，请注意防范疫情流行。<br/>")
				.append("</font><br/><br/><br/>本邮件由系统自动生成，不必回复。");
		return emailContent.toString();
	}

	public void sendSMSMessage(List<Employee> contacts) {
		String smscontent = buildSMSMessage();
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

	public String buildSMSMessage() {
		StringBuilder smscontent = new StringBuilder("尊敬的领导：\n");
		smscontent.append("截止到").append(timeFormat.format(time)).append("，在")
				.append(district).append(duration).append("天内发生了")
				.append(patientNumber).append("起").append(desease)
				.append("感染病例。该数据已超过历史同期水平，请注意防范疫情流行。\n")
				.append("本信息由系统自动生成，不必回复。");
		return smscontent.toString();
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
