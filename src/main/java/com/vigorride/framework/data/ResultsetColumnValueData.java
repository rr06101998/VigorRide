package com.vigorride.framework.data;

import java.io.Serializable;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class ResultsetColumnValueData implements Serializable {
    private final int id;
    private final String value;
    private final String score;
    private final Integer parentId;
}
