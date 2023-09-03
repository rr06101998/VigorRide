package com.vigorride.reports.service;

import com.vigorride.reports.data.CreateReportPayload;
import com.vigorride.reports.data.CreateReportResponse;
import com.vigorride.reports.data.ReportRequestResponse;

public interface ReportWriteService {

    CreateReportResponse createReport(final CreateReportPayload createReportPayload);

    ReportRequestResponse createReportRequest(Long reportId);
}
