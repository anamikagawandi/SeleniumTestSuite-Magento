package com.magento.qa.util;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.magento.qa.base.TestBase;

public class MailerUtil extends TestBase{
	
		public static void mailReport() {

		        //Setting up configurations for the email connection to the Google SMTP server using TLS
		        Properties p = new Properties();
		        p.put("mail.smtp.host", "true");
		        p.put("mail.smtp.starttls.enable", "true");
		        p.put("mail.smtp.host", "smtp.gmail.com");
		        p.put("mail.smtp.port", "587");
		        p.put("mail.smtp.auth", "true");
		        //Establishing a session with required user details
		        Session session = Session.getInstance(p, new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication("preetiprash.ps@gmail.com", "abc");
		            }
		        });
		        try {
		            //Creating a Message object to set the email content
		            MimeMessage msg = new MimeMessage(session);
		            //Storing the comma seperated values to email addresses
		            String to = "anamika.gawandi@gmail.com";
		            /*Parsing the String with defualt delimiter as a comma by marking the boolean as true and storing the email
		            addresses in an array of InternetAddress objects*/
		            InternetAddress[] address = InternetAddress.parse(to, true);
		            //Setting the recepients from the address variable
		            msg.setRecipients(Message.RecipientType.TO, address);
		            String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
		            msg.setSubject("Regression Suite Report : " + timeStamp);
		            msg.setSentDate(new Date());
		            msg.setText("Regression Suite Report");
		            
		            File f=new File(prop.getProperty("reportPath"));
		            		
		            BodyPart bodyPart = new MimeBodyPart();
		            bodyPart.setContent("<h1>Mail from Selenium Project!</h1></br>" , "text/html");
		            Multipart multipart = new MimeMultipart();
		            multipart.addBodyPart(bodyPart);
		            bodyPart = new MimeBodyPart();
		            DataSource source = new FileDataSource(f);
		            bodyPart.setDataHandler(new DataHandler(source));
		            bodyPart.setFileName(f.getPath());
		            multipart.addBodyPart(bodyPart);
		            msg.setContent(multipart);
		            
		            
		            //msg.setHeader("XPriority", "1");
		            Transport.send(msg);
		            System.out.println("Mail has been sent successfully");
		        } catch (MessagingException mex) {
		            System.out.println("Unable to send an email" + mex);
		        }
		    }

		
		public static void main(String args[])
		{
			MailerUtil.mailReport();
		}

}
