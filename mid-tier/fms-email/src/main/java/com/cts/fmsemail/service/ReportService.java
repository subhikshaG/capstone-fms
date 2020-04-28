package com.cts.fmsemail.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.fmsemail.model.Event;
import com.cts.fmsemail.repository.EventRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReportService {


	@Autowired
	EventRepository eventRepository;

	int rowNum = 1;
	String filePath = null;


	public String generateExcelReport() {

		try {

			Workbook workbook = new XSSFWorkbook();
			CreationHelper createHelper = workbook.getCreationHelper();
			// Create Cell Style for formatting Date
			CellStyle dateCellStyle = workbook.createCellStyle();
			dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

			System.out.println(" generateExcelReport ");

			String sheetName = "";

			sheetName = "EventSummary";
			// Create a Sheet
			Sheet sheet = workbook.createSheet("EventSummaryInfo");
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setFontHeightInPoints((short) 12);
			headerFont.setColor(IndexedColors.BLACK.getIndex());

			// Create a CellStyle with the font
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			String[] summary = { "Event No", "Event Name", "Event Description", "Beneficiary Name", "Event Description",
					"Address", "Council Name", "Category", "Project" };
			// Create a Row
			Row headerRow = sheet.createRow(0);
			// Create cells
			for (int i = 0; i < summary.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(summary[i]);
				cell.setCellStyle(headerCellStyle);
			}

			// Create Other rows and cells with employees data
			List<Event> eventlists = eventRepository.findAll().collectList().block();
			for(Event consumer: eventlists) {
				log.info("here");
				
				//consumer = new Event();
				Row row = sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(consumer.getEventNo());
				row.createCell(1).setCellValue(consumer.getEventName());
				row.createCell(2).setCellValue(consumer.getEventDescription());
				row.createCell(3).setCellValue(consumer.getBeneficiaryName());
				row.createCell(4).setCellValue(consumer.getEventDescription());
				row.createCell(5).setCellValue(consumer.getAddress());
				row.createCell(6).setCellValue(consumer.getCouncilName());
				row.createCell(7).setCellValue(consumer.getCategory());
				row.createCell(8).setCellValue(consumer.getProject());

			};
			
			// Resize all columns to fit the content size
			for (int i = 0; i < summary.length; i++) {
				sheet.autoSizeColumn(i);
			}

			// Write the output to a file
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			FileOutputStream fileOut = new FileOutputStream(
					"F:\\subhi\\my projects\\capstone\\feedback-Management-System\\data\\report\\" + sheetName + "" + dateFormat.format(date)+".xlsx");
			filePath = "F:/subhi/my projects/capstone/feedback-Management-System/data/report/" + sheetName  + "" + dateFormat.format(date)+ ".xlsx";
			workbook.write(fileOut);
			fileOut.close();
			// Closing the workbook
			workbook.close();

		}

		// UserInfo Excel
		catch (IOException e) {
			e.printStackTrace();
		}

		return filePath;

	}

}
