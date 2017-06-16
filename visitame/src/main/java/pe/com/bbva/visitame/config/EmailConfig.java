package pe.com.bbva.visitame.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import java.util.Properties;


@Configuration
@ComponentScan(basePackages={"pe.com.bbva.visitame"})
public class EmailConfig {

	   @Bean
	    public JavaMailSender getMailSender(){
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	         
	        //Using gmail
	        mailSender.setHost("smtp.gmail.com");
	        mailSender.setPort(587);
	        mailSender.setUsername("");
	        mailSender.setPassword("");
	         
	        Properties javaMailProperties = new Properties();
	        javaMailProperties.put("mail.smtp.starttls.enable", "true");
	        javaMailProperties.put("mail.smtp.auth", "true");
	        javaMailProperties.put("mail.transport.protocol", "smtp");
	        javaMailProperties.put("mail.debug", "true");//Prints out everything on screen
	         
	        mailSender.setJavaMailProperties(javaMailProperties);
	        return mailSender;
	    }
	
}
