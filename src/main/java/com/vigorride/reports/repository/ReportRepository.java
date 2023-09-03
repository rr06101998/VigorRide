package com.vigorride.reports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vigorride.reports.entity.Report;

public interface ReportRepository extends JpaRepository<Report, Long>{

    List<Report> findByIsActive(boolean b);

    Report findByReportName(String reportName);

}
