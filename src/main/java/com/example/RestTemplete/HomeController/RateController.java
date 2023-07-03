package com.example.RestTemplete.HomeController;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestTemplete.BO.BitRate;
import com.example.RestTemplete.Service.BitRateService;
import com.example.RestTemplete.util.PdfGenerator;
import com.lowagie.text.DocumentException;

@RestController
@RequestMapping("/")
public class RateController {
	@Autowired
	private BitRateService service;
	
	@GetMapping("bitrates")
	public ResponseEntity<List<BitRate>> consumeApi(){
		
		return ResponseEntity.status(HttpStatus.OK).body(service.consumeApi());
	}
	@GetMapping("/export")
	  public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException 
	  {
	    response.setContentType("application/pdf");
	    DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
	    String currentDateTime = dateFormat.format(new Date());
	    String headerkey = "Content-Disposition";
	    String headervalue = "attachment; filename=BitRate" + currentDateTime + ".pdf";
	    response.setHeader(headerkey, headervalue);
	    List < BitRate > listofStudents = service.convertToPdf();
	    PdfGenerator generator = new PdfGenerator();
	    generator.generate(listofStudents, response);
	  }

	

}
