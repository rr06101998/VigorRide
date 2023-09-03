package com.vigorride.reports.service;

import java.io.ByteArrayInputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vigorride.framework.command.DocumentCommand;
import com.vigorride.framework.data.GenericDataService;
import com.vigorride.framework.enums.ContentType;
import com.vigorride.framework.service.ContentConverterFactory;
import com.vigorride.framework.service.ContentRepositoryFactory;
import com.vigorride.reports.annotation.ReportService;
import com.vigorride.reports.constants.ReportConstants;
import com.vigorride.reports.entity.Report;
import com.vigorride.reports.entity.ReportRequest;
import com.vigorride.reports.repository.ReportRepositoryWrapper;
import com.vigorride.reports.repository.ReportRequestRepository;

@Service
@ReportService(type = ReportConstants.STRECHY_REPORT_TYPE)
@Transactional(readOnly = true)
public class ReportProcessingServiceImpl implements ReportProcessingService {

    @Autowired
    private ReportRequestRepository reportRequestRepository;
    @Autowired
    private ReportRepositoryWrapper reportRepositoryWrapper;
    @Autowired
    private GenericDataService genericDataService;
    @Autowired
    private ContentConverterFactory contentConverterFactory;
    @Autowired
    private ContentRepositoryFactory contentRepositoryFactory;

    @Override
    public void generateReport(Long id) {
        final ReportRequest reportRequest = this.reportRequestRepository.findById(id).orElse(null);

        final GenericResultData resultData = getReportResultData(reportRequest.getReportName());

        final byte[] reportDataStream = this.contentConverterFactory.getContentConverter(ContentType.PDF)
                .convert(resultData);
        saveContent(reportDataStream, reportRequest, ContentType.PDF,
                reportRequest.getReportName() + reportRequest.getId());
        System.out.println("sdads");

    }

    private GenericResultData getReportResultData(String reportName) {
        Report report = this.reportRepositoryWrapper.findByReportName(reportName);
        GenericResultData result = this.genericDataService.fillGenericResultSet(report.getReportSql());
        return result;
    }

    private void saveContent(final byte[] data, final ReportRequest reportRequest, ContentType contentType,
            final String reportName) {
        final String fileName = UUID.randomUUID().toString();
        final String entityType = "REPORT";
        final long entityId = reportRequest.getId();
        final ByteArrayInputStream contentInputStream = new ByteArrayInputStream(data);
        DocumentCommand documentCommand = DocumentCommand.builder().parentEntityType(entityType)
                .parentEntityId(entityId).fileName(fileName + contentType.getExtension())
                .size(Long.valueOf(data.length))
                .build();
        final String fileLocation=this.contentRepositoryFactory.getRepository().saveFile(contentInputStream,documentCommand);

    }

}
