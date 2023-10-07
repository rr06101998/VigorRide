package com.vigorride.reports.controller;


import java.io.IOException;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vigorride.commons.constants.VigorRideConstants;
import com.vigorride.framework.data.FileData;
import com.vigorride.reports.data.CreateReportPayload;
import com.vigorride.reports.data.CreateReportResponse;
import com.vigorride.reports.data.FetchReportResponse;
import com.vigorride.reports.data.ReportRequestResponse;
import com.vigorride.reports.service.ReportReadService;
import com.vigorride.reports.service.ReportWriteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(VigorRideConstants.VIGORRIDE_BASE_URL+"/reports") 
public class ReportController {

	@Autowired
	private ReportWriteService reportWriteService;
	@Autowired
	private ReportReadService reportReadService;
	 
	@PostMapping("/create")
	public CreateReportResponse createReport(@Valid @RequestBody CreateReportPayload createReportPayload) {
		return this.reportWriteService.createReport(createReportPayload);
	}

	@GetMapping
	public FetchReportResponse getReport(@QueryParam("reportId") Long reportId) {
		return this.reportReadService.getReport(reportId);
	}
 
	@PostMapping("/{reportId}/create/reportrequest")
	public ReportRequestResponse createReportRequest(@PathVariable Long reportId) {
		return this.reportWriteService.createReportRequest(reportId);
	}

	@GetMapping("/{reportRequestId}/download")
	public ResponseEntity<byte[]> downloadReport(@PathVariable Long reportRequestId) throws IOException {
		FileData fileData=this.reportReadService.downloadReport(reportRequestId);
		byte[] data=fileData.getInputStream().readAllBytes();
		HttpHeaders headers=new HttpHeaders();
		headers.set("Content-Type","application/TXT");
        headers.set("Content-Disposition", "attachment ;filename = N.txt");
		return ResponseEntity.ok().headers(headers).body(data);
	
	}

	
	
	
}
