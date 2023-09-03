package com.vigorride.framework.data;

import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ResultSetRowHeaderData {
    private final List<String> row;

    public static ResultSetRowHeaderData create(List<String> rowValues) {
        return  new ResultSetRowHeaderData(rowValues);
    }
    
}
