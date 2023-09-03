package com.vigorride.framework.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Service;

import com.vigorride.reports.service.GenericResultData;

@Service
public class GenericDataServiceImpl implements GenericDataService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public GenericResultData fillGenericResultSet(String sql) {
        final SqlRowSet rs = this.jdbcTemplate.queryForRowSet(sql);
        final List<ResultSetColumnHeaderData> columnHeaders = new ArrayList<>();
        final List<ResultSetRowHeaderData> rowHeaders = new ArrayList<>();
        final SqlRowSetMetaData rsmd = rs.getMetaData();
        for (int i = 0; i < rsmd.getColumnCount(); i++) {
            final String columnName = rsmd.getColumnLabel(i + 1);
            final String columnType = rsmd.getColumnTypeName(i + 1);
            final ResultSetColumnHeaderData ColumnHeader = ResultSetColumnHeaderData.basic(columnName, columnType);
            columnHeaders.add(ColumnHeader);
        }
        while (rs.next()) {
            final List<String> columnValues = new ArrayList<>();
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                final String columnName = rsmd.getColumnName(i + 1);
                final String columnValue = rs.getString(columnName);
                columnValues.add(columnValue);
            }
            final ResultSetRowHeaderData resultsetDataRow = ResultSetRowHeaderData.create(columnValues);
            rowHeaders.add(resultsetDataRow);
        }
        return new GenericResultData(columnHeaders, rowHeaders);

    }

    @Override
    public String replace(String str, String pattern, String replace) {
       int s=0;
       int e=0;
       final StringBuffer result=new StringBuffer();

       while((e=str.indexOf(pattern,s))>=0){
        result.append(str.substring(s,e));
        result.append(replace);
        s=e+pattern.length();
       }
       result.append(str.substring(s));
       return result.toString();

    }

    

}
