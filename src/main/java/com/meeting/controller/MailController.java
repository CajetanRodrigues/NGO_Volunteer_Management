package com.meeting.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meeting.model.Volunteer;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("rest")
public class MailController {

	
	@GetMapping("/sendMail")
	public static  String sendEmail(String recipientsEmail,Volunteer v) {
		try {
			sendmail(recipientsEmail,v);
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Email sent successfully";
		
	}
	private static void sendmail(String recipientsEmail,Volunteer v) throws AddressException, MessagingException, IOException {
		   Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("cajrod28@gmail.com", "springmaster");
		      }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress("cajrod28@gmail.com", false));

		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientsEmail));
		   msg.setSubject("Registration Confirmation !");
//		   int code = (int)(Math.random() * 100000);
//		   EmailOtp e = new EmailOtp();
//		   e.setEmail(recipientsEmail);
//		   e.setOtp(Integer.toString(code));
//		   this.emailOtpRespository.save(e);
		   msg.setContent("Your code is " + "maverick" , "text/html");
		   msg.setSentDate(new Date());
		   msg.setContent(
		              "<h1>This is actual message embedded in HTML tags</h1>",
		             "text/html");

		   MimeBodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setContent("<h1>Thank you for joining the movement ! Our representatives will get in touch soon !</h1>"
		   		
				   + "<img src='http://www.educationviews.org/wp-content/uploads/2014/03/Indian-school-children-008.jpg' alt=''>"
				   + "<p>Your registered details are as follows </p> "
				   + "<p><b>Name :</b> " + v.getName() +"</p>"
				   + "<p><b>Age :</b>" + v.getAge() + "</p> "
				   + "<p><b>Gender :</b>" + v.getGender() + "</p> "
				   + "<p><b>Phone No. :</b>" + v.getPhoneno()+ "</p> "
				   + "<p><b>email :</b>" + v.getEmail() + "</p> "
				   + "<p><b>Residential Address :</b>" + v.getResidential_address()+ "</p> "
				   + "<p><h2>To view or edit your registered details</h2> </p>" 
				   + "<p>Visit <i>https://www.teachforindia.org/</i></p> <br><br>"
				   + "<p>Thanks and Regards,<br> Teach For India Team</i></p>"
				   
				   , "text/html");
		   
		   Multipart multipart = new MimeMultipart();
		   multipart.addBodyPart(messageBodyPart);
//		   MimeBodyPart attachPart = new MimeBodyPart();
//
//		   attachPart.attachFile("/var/tmp/image19.png");
//		   multipart.addBodyPart(attachPart);
		   msg.setContent(multipart);
		   Transport.send(msg);   
		}
}
