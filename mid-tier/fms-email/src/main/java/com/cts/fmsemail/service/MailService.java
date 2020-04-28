package com.cts.fmsemail.service;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.cts.fmsemail.model.EventDetails;
import com.cts.fmsemail.model.User;
import com.cts.fmsemail.repository.EventDetailsRepository;
import com.cts.fmsemail.repository.EventRepository;
import com.cts.fmsemail.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@Service
public class MailService {

	@Autowired
	JavaMailSender javaMailSender;

	@Autowired
	EventDetailsRepository eventDetailsRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	ReportService reportService;

	int rowNum = 1;
	String filePath = null;

	List<EventDetails> eventDetails = new ArrayList<EventDetails>();

	public Flux<String> sendFeedbackEmail(Integer eventId) {

		eventDetails = this.eventDetailsRepository.getUsersByEventId(eventId).collectList().block();
		log.info("my events" + eventDetails);
		return Flux.fromStream(eventDetails.stream().map(event -> {

			try {
				if (event.getParticipation().equals("Y")) {
					System.out.println("in service");
					String text = "Provide feedback for your particpation." + "\n\n"
							+ "http://localhost:8083/users/email/";
					SimpleMailMessage message = new SimpleMailMessage();

					User user = userRepository.findById(event.getUserId()).block();

					message.setTo(user.getEmail());
					// message.setTo(user.getEmail());
					log.info("1");
					message.setFrom("stockregistermgmt@gmail.com");
					log.info("2");
					message.setSubject("Participation.Please provided your feedback for EVM" + event.getEventId());
					log.info("3");
					message.setText(text);
					log.info("4");
					javaMailSender.send(message);
					log.info("5");
				} else if (event.getParticipation().equals("NA")) {
					System.out.println("in service");
					String text = "Provide feedback for not attending" + "\n\n" + "http://localhost:8083/users/email/";
					SimpleMailMessage message = new SimpleMailMessage();

					User user = userRepository.findById(event.getUserId()).block();
					message.setTo(user.getEmail());
					log.info("1");
					message.setFrom("stockregistermgmt@gmail.com");
					log.info("2");
					message.setSubject("Not Attended.Please provided your feedback for EVM" + event.getEventId());
					log.info("3");
					message.setText(text);
					log.info("4");
					javaMailSender.send(message);
					log.info("5");
				} else if (event.getParticipation().equals("UR")) {
					System.out.println("in service");
					String text = "Provide feedback for unregistering" + "\n\n" + "http://localhost:8083/users/email/";
					SimpleMailMessage message = new SimpleMailMessage();

					User user = userRepository.findById(event.getUserId()).block();
					message.setTo(user.getEmail());
					log.info("1");
					message.setFrom("stockregistermgmt@gmail.com");
					log.info("2");
					message.setSubject("Unregistered. Please provided your feedback for EVM" + event.getEventId());
					log.info("3");
					message.setText(text);
					log.info("4");
					javaMailSender.send(message);
					log.info("5");
				}

			}

			catch (Exception exception) {
				System.out.println("my exception is" + exception);
				return ("Failed to send email");
			}
			return ("Email Sent. Please verify");

		}));

	}

	public void sendReportMail(String email) {

		MimeMessage message = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom("stockregistermgmt@gmail.com");
			helper.setTo(email);
			helper.setSubject("Events details");
			helper.setText("attached file");

			String path = reportService.generateExcelReport();
			log.info("my path is"+path);
			FileSystemResource file = new FileSystemResource(path);
			helper.addAttachment(file.getFilename(), file);
			log.info("attached");

		} catch (MessagingException e) {
			throw new MailParseException(e);
		}
		javaMailSender.send(message);
		log.info("sent mail");
	}

}
