package com.vigorride.reports.data;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateReportPayload {
    
	@NotNull
	private String reportName;
	
	@NotNull
	private String reportSql;

    @NotNull
	private Boolean isActive;

    @NotNull
	private Boolean isUserReport;
}
