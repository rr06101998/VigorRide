package com.vigorride.reports.service;

import java.util.List;

import com.vigorride.framework.data.ResultSetColumnHeaderData;
import com.vigorride.framework.data.ResultSetRowHeaderData;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public final class GenericResultData {
 
    private final List<ResultSetColumnHeaderData> columnHeader;
    private final List<ResultSetRowHeaderData> rowHeader;

    
}
