package elites.model;
import java.util.Properties;
import java.security.*;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Mail   {
	String host= "smtp.gmail.com", user="anthony.dsz12@gmail.com", pass="madharchod";
	String from ="ECops@tn.gov.in"; 
	
	public Mail(){
		super();
	}
	public boolean GmailSend  (String to,String subject,String messageText){
		
								String host=
								"smtp.gmail.com", user="anthony.dsz12@gmail.com", pass="madharchod";
						
						//		host = smtp_server; //"smtp.gmail.com"; user = jsp_email; //"YourEmailId@gmail.com" // email id to send the emails
						
						//		pass = jsp_email_pw; //Your gmail password
						
								String SSL_FACTORY ="javax.net.ssl.SSLSocketFactory";
						
								
						
								//String from ="ECops@tn.gov.in"; //Email id of the recipient
						
								
						
								//String messageText ="email_body";
						
								boolean sessionDebug = true;
								//java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
						
								Properties props = System.getProperties();
						
								props.put("mail.host", host);
						
								props.put("mail.transport.protocol.", "smtp");
						
								props.put("mail.smtp.auth", "true");
						
								props.put("mail.smtp.", "true");
						
								props.put("mail.smtp.port", "465");
						
								props.put("mail.smtp.socketFactory.fallback", "false");
						
								props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
						
								Session mailSession = Session.getDefaultInstance(props,null);
						
								mailSession.setDebug(sessionDebug);
						
								Message msg =new MimeMessage(mailSession);
						
								//msg.setFrom(new InternetAddress(from));
								try
								{
								InternetAddress[] address = {new InternetAddress(to)};
						
								msg.setRecipients(Message.RecipientType.TO, address);
						
								msg.setSubject(subject);
						
								msg.setContent(messageText,"text/html"); // use setText if you want to send text
						
								Transport transport = mailSession.getTransport("smtp");
						
								transport.connect(host, user, pass);
						
								
						
								transport.sendMessage(msg, msg.getAllRecipients());
						
								//WasEmailSent = true; // assume it was sent
								return true; 
						
								}
						
								catch
								(Exception err) {
						
								//WasEmailSent = false; // assume it's a fail
									return false; 
						
								//System.out.println("Error"+err.getMessage());
						
								}
						
								//transport.close();

		
	}
}
