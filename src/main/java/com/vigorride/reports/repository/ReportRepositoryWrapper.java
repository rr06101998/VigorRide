package com.vigorride.reports.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigorride.reports.entity.Report;

@Service
public class ReportRepositoryWrapper {

    @Autowired
    private ReportRepository reportRepository;

    public Report save(Report report) {
        return this.reportRepository.save(report);
    }

    public Optional<Report> findbyId(Long id) {
        return this.reportRepository.findById(id);
    }

    public List<Report> findByIsActive(boolean isActive) {
        return this.reportRepository.findByIsActive(isActive);
    }

    public Report findByReportName(String reportName) {
        return this.reportRepository.findByReportName(reportName);

    }

}
