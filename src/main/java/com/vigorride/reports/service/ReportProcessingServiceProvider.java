package com.vigorride.reports.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.vigorride.reports.annotation.ReportService;

@Service
public class ReportProcessingServiceProvider implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    Map<String, String> reportProcessingServices;

    public ReportProcessingService getReportProcessingService(String reportType) {
        if(this.reportProcessingServices.containsKey(reportType)){
            return  (ReportProcessingService) this.applicationContext.getBean(this.reportProcessingServices.get(reportType));
        }
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        intializeRegistry();
    }

    private void intializeRegistry() {
        if (Objects.isNull(reportProcessingServices)) {
            this.reportProcessingServices = new HashMap<>();

            final String[] reportServicesBeans = this.applicationContext.getBeanNamesForAnnotation(ReportService.class);
            if (ArrayUtils.isNotEmpty(reportServicesBeans)) {
                for (final String reportName : reportServicesBeans) {
                    final ReportService service = this.applicationContext.findAnnotationOnBean(reportName,
                            ReportService.class);
                    try {
                        this.reportProcessingServices.put(service.type(), reportName);
                    } catch (final Throwable th) {

                    }
                }
            }
        }
    }

}
