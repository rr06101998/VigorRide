package com.vigorride.reports.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigorride.framework.data.DocumentData;
import com.vigorride.framework.data.FileData;
import com.vigorride.framework.repository.ContentRepository;
import com.vigorride.framework.service.ContentRepositoryFactory;
import com.vigorride.reports.data.FetchReportResponse;
import com.vigorride.reports.data.GetReportResponse;
import com.vigorride.reports.entity.Report;
import com.vigorride.reports.repository.ReportRepositoryWrapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportReadServiceImpl implements ReportReadService {

    @Autowired
    private ReportRepositoryWrapper reportRepositoryWrapper;
    @Autowired
    private ContentRepositoryFactory contentRepositoryFactory;

    @Override
    public FetchReportResponse getReport(final Long id) {
        List<GetReportResponse> getReportResponse = new ArrayList<>();
        if (id != null) {
            Optional<Report> report = this.reportRepositoryWrapper.findbyId(id);
            if (report.isPresent()) {
                GetReportResponse reponse = GetReportResponse.builder().id(report.get().getId())
                        .reportName(report.get().getReportName())
                        .reportSql(report.get().getReportSql())
                        .isActive(report.get().getIsActive())
                        .isUserReport(report.get().getIsUserReport())
                        .build();
                getReportResponse.add(reponse);
                return FetchReportResponse.builder().reports(getReportResponse).build();
            }
            return FetchReportResponse.builder().reports(getReportResponse).build();
        }
        

        List<Report> reports= this.reportRepositoryWrapper.findByIsActive(true);
        for(Report report:reports){
            GetReportResponse reponse = GetReportResponse.builder().id(report.getId())
                        .reportName(report.getReportName())
                        .reportSql(report.getReportSql())
                        .isActive(report.getIsActive())
                        .isUserReport(report.getIsUserReport())
                        .build();
            getReportResponse.add(reponse);
        }
        return FetchReportResponse.builder().reports(getReportResponse).build();

        
    }

    @Override
    public FileData downloadReport(Long reportRequestId) {
        final ContentRepository contentRepository=this.contentRepositoryFactory.getRepository();
        DocumentData data=DocumentData.builder().fileName("file").location("/Users/rayadav/REPORT/13/ced97b998c/1f689218-3cde-429a-9397-ba306ad7e711.pdf").build();
        return contentRepository.fetchFile(data);


    }

}
