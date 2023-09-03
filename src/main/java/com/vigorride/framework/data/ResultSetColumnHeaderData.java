package com.vigorride.framework.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public final class ResultSetColumnHeaderData implements Comparable<ResultSetColumnHeaderData>, Serializable {
    private String columnName;
    private String columnType;
    private Long columnLength;
    private String columnDisplayType;
    private boolean isColumnNullable;
    @SuppressWarnings("unused")
    private boolean isColumnPrimaryKey;
    @SuppressWarnings("unused")
    private String displayName;
    @SuppressWarnings("unused")
    private String dependsOnColumnName;
    @SuppressWarnings("unused")
    private Long orderPosition;
    @SuppressWarnings("unused")
    private Boolean visible;
    @SuppressWarnings("unused")
    private Boolean mandatoryIfVisible;
    private Long sectionId;
    private Boolean readOnly;
    private String formula;
    private List<ResultsetColumnValueData> columnValues;
    private String columnCode;

    public ResultSetColumnHeaderData(String columnName, String columnType, Long columnLength, boolean columnNullable,
            boolean columnIsPrimaryKey, List<ResultsetColumnValueData> columnValues, String columnCode,
            String displayName, String dependsOnColumnName, Long orderPosition, Boolean visible,
            Boolean mandatoryIfVisible, Long sectionId, Boolean readOnly, String formula) {
        this.columnName = columnName;
        this.columnType = columnType;
        this.columnLength = columnLength;
        this.isColumnNullable = columnNullable;
        this.isColumnPrimaryKey = columnIsPrimaryKey;
        this.columnValues = columnValues;
        this.columnCode = columnCode;
        this.displayName = displayName;
        this.dependsOnColumnName = dependsOnColumnName;
        this.orderPosition = orderPosition;
        this.visible = visible;
        this.mandatoryIfVisible = mandatoryIfVisible;
        this.sectionId = sectionId;
        this.readOnly = readOnly;
        this.formula = formula;

    }

    @Override
    public int compareTo(ResultSetColumnHeaderData resultcolumnData) {
        return this.orderPosition.intValue() - resultcolumnData.orderPosition.intValue();
    }

    public static ResultSetColumnHeaderData basic(
            String columnName,
            String columnType) {

        Long columnLength = null;
        boolean columnNullable = false;
        boolean columnIsPrimaryKey = false;
        String displayName = null;
        List<ResultsetColumnValueData> columnValues = new ArrayList<>();
        String columnCode = null;
        Long orderPosition = null;
        String dependsOnColumnName = null;
        Boolean visible = null;
        Boolean mandatoryIfVisible = null;
        Long sectionId = null;
        Boolean readOnly = null;
        String formula = null;

        return new ResultSetColumnHeaderData(
                columnName,
                columnType,
                columnLength,
                columnNullable,
                columnIsPrimaryKey,
                columnValues,
                columnCode,
                displayName,
                dependsOnColumnName,
                orderPosition,
                visible,
                mandatoryIfVisible,
                sectionId,
                readOnly,
                formula);
    }

}
