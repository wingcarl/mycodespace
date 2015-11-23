package net;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailTest {
	public static void main(String[] args) throws IOException, AddressException, MessagingException{
		Properties props = new Properties();
		try(InputStream in = Files.newInputStream(Paths.get("mail","mail.properties"))){
			props.load(in);
		}
		List<String> lines = Files.readAllLines(Paths.get("mail","message.txt"),Charset.forName("UTF-8"));
		String from = lines.get(0);
		String to = lines.get(1);
		String subject = lines.get(2);
		StringBuilder sb = new StringBuilder();
		for(int i=3;i<lines.size();i++){
			sb.append(lines.get(i));
			sb.append("\n");
		}
		Scanner in = new Scanner(System.in);
		String password = in.nextLine();
		
		Session mailSession = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(mailSession);
		message.setFrom(new InternetAddress(from));
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		message.setSubject(subject);
		message.setText(sb.toString());
		Transport tr = mailSession.getTransport();
		try{
			tr.connect(null,password);
			tr.sendMessage(message, message.getAllRecipients());
		}
		finally{
			tr.close();
		}
	}
}
