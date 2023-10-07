package com.vigorride.reports.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigorride.reports.entity.ReportRequest;

@Service
public class ReportRequestRepositoryWrapper {

    @Autowired
    private ReportRequestRepository reportRequestRepository;

    public ReportRequest save(ReportRequest reportRequest) {
        return this.reportRequestRepository.save(reportRequest);
    }

    public Optional<ReportRequest> findById(Long id) {
        return  this.reportRequestRepository.findById(id);
    }

    

}
