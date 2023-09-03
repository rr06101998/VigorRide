package com.vigorride.reports.service;

import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.vigorride.reports.constants.ReportConstants;
import com.vigorride.reports.data.CreateReportPayload;
import com.vigorride.reports.data.CreateReportResponse;
import com.vigorride.reports.data.ReportRequestResponse;
import com.vigorride.reports.entity.Report;
import com.vigorride.reports.entity.ReportRequest;
import com.vigorride.reports.repository.ReportRepositoryWrapper;
import com.vigorride.reports.repository.ReportRequestRepositoryWrapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportWriteServiceImpl implements ReportWriteService {

    @Autowired
    private ReportRepositoryWrapper reportRepositoryWrapper;
    @Autowired
    private ReportRequestRepositoryWrapper reportRequestRepositoryWrapper;
    @Autowired
    private ReportProcessingServiceProvider reportProcessingServiceProvider;

    @Override
    public CreateReportResponse createReport(CreateReportPayload createReportPayload) {
        Report report = Report.builder()
                .reportName(createReportPayload.getReportName())
                .reportSql(createReportPayload.getReportSql())
                .isActive(createReportPayload.getIsActive())
                .isUserReport(createReportPayload.getIsUserReport())
                .build();
        report = this.reportRepositoryWrapper.save(report);

        return CreateReportResponse.builder().reportId(report.getId()).reportName(report.getReportName())
                .reportSql(report.getReportSql()).isActive(report.getIsActive())
                .isUserReport(report.getIsUserReport()).build();
    }

    @Override
    public ReportRequestResponse createReportRequest(Long reportId) {

        Optional<Report> report = this.reportRepositoryWrapper.findbyId(reportId);
        if (!report.isPresent()) {
            // not present;
        }
        ReportRequest reportRequest = ReportRequest.builder().reportName(report.get().getReportName())
                .reportSql(report.get().getReportSql())
                .status(200L)
                .locationId(null).build();
        reportRequest = this.reportRequestRepositoryWrapper.save(reportRequest);
        reportGenerationProcess(reportRequest.getId());
        ReportRequestResponse reportRequestResponse = ReportRequestResponse.builder()
                .reportName(report.get().getReportName())
                .reportSql(report.get().getReportSql())
                .status(200L)
                .locationId(null)
                .build();
        return reportRequestResponse;

    }

    private void reportGenerationProcess(Long reportRequestId) {
        ReportProcessingService reportProcessingService = this.reportProcessingServiceProvider
                .getReportProcessingService(ReportConstants.STRECHY_REPORT_TYPE);
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(new ReportGenerationInvoker(reportRequestId, reportProcessingService), 3,
                TimeUnit.SECONDS);
    }

    private class ReportGenerationInvoker implements Runnable {

        private final Long reportRequestId;
        private final Authentication auth;
        final ReportProcessingService reportProcessingService;

        ReportGenerationInvoker(final Long reportRequestId, final ReportProcessingService reportProcessingService) {
            this.reportRequestId = reportRequestId;
            this.auth = SecurityContextHolder.getContext().getAuthentication();
            this.reportProcessingService = reportProcessingService;
        }

        @Override
        public void run() {
            this.reportProcessingService.generateReport(reportRequestId);
        }

    }

}
