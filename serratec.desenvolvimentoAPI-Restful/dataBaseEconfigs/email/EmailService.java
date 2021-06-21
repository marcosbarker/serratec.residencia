package com.residencia.dell.services;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.residencia.dell.exceptions.EmailException;
import com.residencia.dell.vo.NotaFiscalVO;

@Component
public class EmailService {
	@Autowired
	private JavaMailSender emailSender;

	@Value("${spring.mail.username}")
	private String emailRemetente;
	
	@Value("${spring.mail.host}")
	private String emailServerHost;
	
	@Value("${spring.mail.port}")
	private Integer emailServerPort;
	
	@Value("${spring.mail.username}")
	private String emailServerUserName;
	
	@Value("${spring.mail.password}")
	private String emailServerPassword;
	
	@Value("${spring.mail.protocol}")
	private String emailServerProtocol;
	
	public JavaMailSender javaMailSender() {

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		Properties prop = new Properties();

		mailSender.setHost(emailServerHost);
		mailSender.setPort(emailServerPort);
		mailSender.setUsername(emailServerUserName);
		mailSender.setPassword(emailServerPassword);
		mailSender.setProtocol("smtp");
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", false);
		mailSender.setJavaMailProperties(prop);

		return mailSender;

	}

	public void emailNotaFiscal(NotaFiscalVO emailVO) throws MessagingException, EmailException {

		this.emailSender = javaMailSender();

		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		try {
			helper.setFrom(emailRemetente);
			helper.setTo("aopaixao@gmail.com");
			helper.setSubject("Nota Fiscal Nº " + emailVO.getOrderId());

			SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm:ss");
			DecimalFormat dfMoeda = new DecimalFormat("R$ ,##0.00");

			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("<html>\r\n");
			sBuilder.append("	<body>\r\n");
			sBuilder.append("		<div align=\"center\">\r\n");
			sBuilder.append("			NOTA FISCAL\r\n");
			sBuilder.append("		</div>\r\n");
			sBuilder.append("		<br/>\r\n");
			sBuilder.append("		<center>\r\n");
			sBuilder.append("		<table border='1' cellpadding='5'  >\r\n");
			sBuilder.append("<tr><th>Nº Nota</th><th>Customer</th><th>Total Amount</th><th>Order Date</th></tr>\r\n");

			sBuilder.append("		<tr>\r\n");
			sBuilder.append("			<td>\r\n");
			sBuilder.append(emailVO.getOrderId());
			sBuilder.append("			</td>\r\n");
			sBuilder.append("			<td>\r\n");
			sBuilder.append(emailVO.getCustomerFirstName() + " " + emailVO.getCustomerLastName());
			sBuilder.append("			</td>\r\n");
			sBuilder.append("			<td>\r\n");
			sBuilder.append(dfMoeda.format(emailVO.getTotalAmount()));
			sBuilder.append("			</td>\r\n");
			sBuilder.append("			<td>\r\n");
			sBuilder.append(sdfData.format(emailVO.getOrderDate().getTime()));
			sBuilder.append("			</td>\r\n");
			sBuilder.append("		</tr>\r\n");

			sBuilder.append("		</table>\r\n");
			sBuilder.append("		</center>\r\n");
			sBuilder.append("	</body>\r\n");
			sBuilder.append("</html>");

			helper.setText(sBuilder.toString(), true);

			emailSender.send(message);

		} catch (Exception e) {
			throw new EmailException("Houve erro ao enviar o email de Nota Fiscal: " + e.getMessage());
		}

	}

}
