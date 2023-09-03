package com.vigorride.reports.service;

import com.vigorride.reports.data.FetchReportResponse;

public interface ReportReadService {

    FetchReportResponse getReport(final Long id);

}
