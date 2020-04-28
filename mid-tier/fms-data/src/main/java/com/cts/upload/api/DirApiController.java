package com.cts.upload.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.upload.model.Event;
import com.cts.upload.model.EventDetails;
import com.cts.upload.model.EventSummary;
import com.cts.upload.repository.EventsDetailsRepository;
import com.cts.upload.repository.EventsRepository;
import com.cts.upload.repository.EventsSummaryRepository;
import com.cts.upload.service.UploadService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-13T10:19:49.709+05:30")

@Slf4j
@Controller
public class DirApiController implements DirApi {

	@Autowired
	private EventsRepository eventRepository;

	@Autowired
	private EventsSummaryRepository eventSummaryRepository;

	@Autowired
	private EventsDetailsRepository eventDetailsRepository;

	@Autowired
	private UploadService up;

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private List<Event> eventlist;

	private List<EventSummary> summaryList;

	private List<EventDetails> eventDetailsList;

	@org.springframework.beans.factory.annotation.Autowired
	public DirApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Override
	public Optional<ObjectMapper> getObjectMapper() {
		return Optional.ofNullable(objectMapper);
	}

	@Override
	public Optional<HttpServletRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	public Mono<ResponseEntity<String>> dirGet() {

		try {
			return Flux.fromStream(Files.walk(Paths.get(
					"F:/subhi/my projects/capstone/feedback-Management-System/data/inputs/OutReach Event Information.xlsx")))
					.map(dataBuffer -> {
						eventlist = new ArrayList<Event>();
						XSSFWorkbook workbook = null;
						try {
							log.info("" + dataBuffer.getFileName());
							if (dataBuffer.getFileName().startsWith("OutReach Event Information.xlsx")) {

								workbook = new XSSFWorkbook(dataBuffer.toFile());
								XSSFSheet sheet = workbook.getSheetAt(0);
								log.info("My rows" + +sheet.getPhysicalNumberOfRows());
								for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
									XSSFRow row = sheet.getRow(i);
									log.info("msg" + row.getCell(0));
									Event ev = Event.builder().eventNo(row.getCell(0).getStringCellValue())
											.month(row.getCell(15).getStringCellValue())
											.location(row.getCell(1).getStringCellValue())
											.beneficiaryName(row.getCell(2).getStringCellValue())
											.councilName(row.getCell(3).getStringCellValue())
											.project(row.getCell(12).getStringCellValue())
											.address(row.getCell(2).getStringCellValue())
											.eventName(row.getCell(4).getStringCellValue())
											.eventDescription(row.getCell(5).getStringCellValue())											
											.category(row.getCell(14).getStringCellValue()).build();
									log.info("ended" + ev);
									eventlist.add(ev);

								}

							}

							workbook.close();

							Date date = new Date();
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
							Path destinationepath = Paths
									.get("F:/subhi/my projects/capstone/feedback-Management-System/data/output/"
											+ dataBuffer.getFileName() + "" + dateFormat.format(date) + ".xlsx");
							Files.copy(dataBuffer, destinationepath, StandardCopyOption.REPLACE_EXISTING);
						} catch (Exception e) {
							e.printStackTrace();
						}
						log.info("my events" + eventlist.toString());

						return Flux.just(this.eventRepository.saveAll(eventlist).subscribe())
								.then(Mono.just(ResponseEntity.status(HttpStatus.OK).body("successfully uploaded")));
					}).map(map -> {
						this.eventRepository.saveAll(eventlist);
						log.info("saved successfully");
						return map;
					}).then(Mono.just(ResponseEntity.status(HttpStatus.OK).body("successfully uploaded all")));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return Mono.just(ResponseEntity.status(HttpStatus.OK).body("successfully uploaded ends here"));

	}

	public Mono<ResponseEntity<String>> dirPostSummary() {

		try {
			return Flux.fromStream(Files.walk(Paths.get(
					"F:/subhi/my projects/capstone/feedback-Management-System/data/inputs/Outreach Events Summary.xlsx")))
					.map(dataBuffer -> {
						summaryList = new ArrayList<EventSummary>();
						XSSFWorkbook workbook = null;
						try {
							log.info("" + dataBuffer.getFileName());
							if (dataBuffer.getFileName().startsWith("Outreach Events Summary.xlsx")) {

								workbook = new XSSFWorkbook(dataBuffer.toFile());
								XSSFSheet sheet = workbook.getSheetAt(0);
								log.info("My rows" + +sheet.getPhysicalNumberOfRows());
								for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
									XSSFRow row = sheet.getRow(i);
									log.info("msg" + row.getCell(0));

									EventSummary eventSummary = EventSummary.builder()
											.totalVolunteer(Integer.parseInt(row.getCell(11).getRawValue()))
											.livesImpact(row.getCell(15).getNumericCellValue())
											.avgVolunteer(row.getCell(14).getNumericCellValue())
											.eventId(Integer.parseInt(row.getCell(0).getRawValue()))
											.noOfHrs(row.getCell(12).getNumericCellValue())
											.travelHrs(row.getCell(13).getNumericCellValue()).build();
									log.info("ended" + eventSummary);
									summaryList.add(eventSummary);
								}

							}

							workbook.close();

							Date date = new Date();
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
							Path destinationepath = Paths
									.get("F:/subhi/my projects/capstone/feedback-Management-System/data/output/"
											+ dataBuffer.getFileName() + "" + dateFormat.format(date) + ".xlsx");
							Files.copy(dataBuffer, destinationepath, StandardCopyOption.REPLACE_EXISTING);
						} catch (Exception e) {
							e.printStackTrace();
						}
						log.info("my events");

						return Flux.just(this.eventSummaryRepository.saveAll(summaryList).subscribe()).then(
								Mono.just(ResponseEntity.status(HttpStatus.OK).body("successfully summary uploaded")));
					}).map(map -> {

						log.info("saved successfully");
						return map;
					}).then(Mono.just(ResponseEntity.status(HttpStatus.OK).body("successfully summary uploaded all")));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return Mono.just(ResponseEntity.status(HttpStatus.OK).body("successfully summary uploaded ends here"));

	}

	public Mono<ResponseEntity<String>> dirPostParticipantNotAttended() {
		try {
			return Flux.fromStream(Files.walk(Paths.get(
					"F:/subhi/my projects/capstone/feedback-Management-System/data/inputs/Volunteer_Enrollment Details_Not_Attended.xlsx")))
					.map(dataBuffer -> {
						eventDetailsList = new ArrayList<EventDetails>();
						XSSFWorkbook workbook = null;
						try {
							log.info("" + dataBuffer.getFileName());
							if (dataBuffer.getFileName().startsWith("Volunteer_Enrollment Details_Not_Attended.xlsx")) {

								workbook = new XSSFWorkbook(dataBuffer.toFile());
								XSSFSheet sheet = workbook.getSheetAt(0);
								log.info("My rows" + +sheet.getPhysicalNumberOfRows());
								for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
									XSSFRow row = sheet.getRow(i);
									log.info("msg" + row.getCell(0));

									EventDetails eventDetails = EventDetails.builder()
											.eventId(Integer.parseInt(row.getCell(0).getRawValue()))
											.userId(Integer.parseInt(row.getCell(5).getRawValue())).travelHr(0.0)
											.volunteerHr(0.0).participation("NA").build();
									log.info("ended" + eventDetails);
									eventDetailsList.add(eventDetails);
								}

							}

							workbook.close();

							Date date = new Date();
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
							Path destinationepath = Paths
									.get("F:/subhi/my projects/capstone/feedback-Management-System/data/output/"
											+ dataBuffer.getFileName() + "" + dateFormat.format(date) + ".xlsx");
							Files.copy(dataBuffer, destinationepath, StandardCopyOption.REPLACE_EXISTING);
						} catch (Exception e) {
							e.printStackTrace();
						}
						log.info("my events");

						return Flux.just(this.eventDetailsRepository.saveAll(eventDetailsList).subscribe()).then(Mono
								.just(ResponseEntity.status(HttpStatus.OK).body("successfully Not attended uploaded")));
					}).map(map -> {

						log.info("saved successfully");
						return map;
					}).then(Mono
							.just(ResponseEntity.status(HttpStatus.OK).body("successfully Not attended uploaded all")));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return Mono.just(ResponseEntity.status(HttpStatus.OK).body("successfully Not attended uploaded ends here"));

	}

	public Mono<ResponseEntity<String>> dirPostParticipantUnregister() {
		try {
			return Flux.fromStream(Files.walk(Paths.get(
					"F:/subhi/my projects/capstone/feedback-Management-System/data/inputs/Volunteer_Enrollment Details_Unregistered.xlsx")))
					.map(dataBuffer -> {
						eventDetailsList = new ArrayList<EventDetails>();
						XSSFWorkbook workbook = null;
						try {
							log.info("" + dataBuffer.getFileName());
							if (dataBuffer.getFileName().startsWith("Volunteer_Enrollment Details_Unregistered.xlsx")) {

								workbook = new XSSFWorkbook(dataBuffer.toFile());
								XSSFSheet sheet = workbook.getSheetAt(0);
								log.info("My rows" + +sheet.getPhysicalNumberOfRows());
								for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
									XSSFRow row = sheet.getRow(i);
									log.info("msg" + row.getCell(0));

									EventDetails eventDetails = EventDetails.builder()
											.eventId(Integer.parseInt(row.getCell(0).getRawValue()))
											.userId(Integer.parseInt(row.getCell(5).getRawValue())).travelHr(0.0)
											.volunteerHr(0.0).participation("UR").build();
									log.info("ended" + eventDetails);
									eventDetailsList.add(eventDetails);
								}

							}

							workbook.close();

							Date date = new Date();
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
							Path destinationepath = Paths
									.get("F:/subhi/my projects/capstone/feedback-Management-System/data/output/"
											+ dataBuffer.getFileName() + "" + dateFormat.format(date) + ".xlsx");
							Files.copy(dataBuffer, destinationepath, StandardCopyOption.REPLACE_EXISTING);
						} catch (Exception e) {
							e.printStackTrace();
						}
						log.info("my events");

						return Flux.just(this.eventDetailsRepository.saveAll(eventDetailsList).subscribe()).then(Mono
								.just(ResponseEntity.status(HttpStatus.OK).body("successfully unregister uploaded")));
					}).map(map -> {
						log.info("saved successfully");
						return map;
					})
					.then(Mono.just(ResponseEntity.status(HttpStatus.OK).body("successfully unregister uploaded all")));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return Mono.just(ResponseEntity.status(HttpStatus.OK).body("successfully unregister uploaded ends here"));
	}
}
