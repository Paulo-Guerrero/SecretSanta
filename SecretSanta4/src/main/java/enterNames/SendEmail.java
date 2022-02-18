package enterNames;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {
	private String to;
	private String name;
	private String Santa;
	private String Msg;
	
	public SendEmail() {
		to = "pguerrero@hotmail.ca";
		name = "Paulo";
		Santa = "Paulo Santa";
		Msg = null;
		
	}
	public SendEmail(String email, String recepient, String santa, String msg) {
		to = email;
		name = recepient;
		Santa = santa;
		Msg = msg;
		
	}
	
	public void send() {
		final String username = "secretsantajava@gmail.com";
		final String password = "123itisMe!";
		
		  Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          props.put("mail.smtp.ssl.enable", "true");
          props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			
          Session session = Session.getDefaultInstance(props,    
                  new javax.mail.Authenticator() {    
                  protected PasswordAuthentication getPasswordAuthentication() {    
                  return new PasswordAuthentication(username,password);  
                  }    
                 });  
	      try {
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(username));
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         message.setSubject("Hi, "+Santa+"! Your Secret Santa Name has Been Drawn!!!\n");

	         message.setText("Your Secret Santa name is... "+name+"\nA special message from your host...\n"+"\n"+Msg+"\n\nHave fun!");

	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	      
	
		
	
	}
	public static void main(String[] args) {
		SendEmail SendEmail = new SendEmail();
		SendEmail.send();
	}
}