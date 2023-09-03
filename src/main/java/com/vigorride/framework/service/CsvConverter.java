package com.vigorride.framework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vigorride.framework.data.GenericDataService;
import com.vigorride.framework.data.ResultSetColumnHeaderData;
import com.vigorride.framework.data.ResultSetRowHeaderData;
import com.vigorride.reports.service.GenericResultData;

@Component
public class CsvConverter implements ContentConverter {

    @Autowired
    private GenericDataService genericDataService;
    @Autowired
    private IOUtils ioUtils;

    @Override
    public byte[] convert(final GenericResultData genericResultData) {
        try {
            final StringBuffer sb = generateCsvFileBuffer(genericResultData);
            return this.ioUtils.read(sb.toString());
        } catch (final Exception e) {

        }
        return null;

    }

    private StringBuffer generateCsvFileBuffer(final GenericResultData result) {
        final StringBuffer writer = new StringBuffer();
        final List<ResultSetColumnHeaderData> columnHeaders = result.getColumnHeader();
        final Integer chSize = columnHeaders.size();
        for (int i = 0; i < chSize; i++) {
            writer.append('"' + columnHeaders.get(i).getColumnName() + '"');
            if (i < (chSize - 1)) {
                writer.append(",");
            }
        }
        writer.append('\n');
        final List<ResultSetRowHeaderData> data = result.getRowHeader();
        List<String> row;
        Integer rSize;
        String currColType;
        String currVal;
        final String doubleQuote = "\"";
        final String twoDoubleQuotes = doubleQuote + doubleQuote;
        for (int i = 0; i < data.size(); i++) {
            row = data.get(i).getRow();
            rSize = row.size();
            for (int j = 0; j < rSize; j++) {
                currColType = columnHeaders.get(j).getColumnType();
                currVal = row.get(j);
                if (currVal != null) {
                    if (currColType.equals("DECIMAL") || currColType.equals("DOUBLE") || currColType.equals("BIGINT")
                            || currColType.equals("SMALLINT") || currColType.equals("INT")) {
                        writer.append(currVal);
                    } else {
                        writer.append(
                                '"' + this.genericDataService.replace(currVal, doubleQuote, twoDoubleQuotes) + '"');
                    }
                }
                if (j < (rSize - 1)) {
                    writer.append(",");
                }
            }
            writer.append('\n');
        }
        return writer;
    }
}
