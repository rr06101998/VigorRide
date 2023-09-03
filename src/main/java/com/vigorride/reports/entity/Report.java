package com.vigorride.reports.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Report")
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "report_name", nullable = false)
	private String reportName;

	@NotNull
	@Column(name = "report_sql", nullable = false)
	private String reportSql;

	@Column(name = "isActive")
    @Default
	private Boolean isActive=false;

	@Column(name = "isUserReport")
    @Default
	private Boolean isUserReport=false;
}
