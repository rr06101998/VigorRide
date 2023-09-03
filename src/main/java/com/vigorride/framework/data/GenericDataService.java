package com.vigorride.framework.data;

import com.vigorride.reports.service.GenericResultData;

public interface GenericDataService {
    GenericResultData fillGenericResultSet(final String sql);

    String replace(final String str,final String pattern,final String replace);
    
}
