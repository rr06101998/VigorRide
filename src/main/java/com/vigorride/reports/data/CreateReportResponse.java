package com.vigorride.reports.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateReportResponse {
    
    private Long reportId;
	private String reportName;
	private String reportSql;
	private Boolean isActive;
	private Boolean isUserReport;
}
