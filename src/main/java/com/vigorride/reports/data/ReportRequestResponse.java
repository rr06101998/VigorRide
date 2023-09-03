package com.vigorride.reports.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ReportRequestResponse {
    private String reportName;
    private String reportSql;
    private Long status;
    private Long locationId;
}
