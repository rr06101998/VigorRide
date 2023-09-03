package com.vigorride.framework.service;

import com.vigorride.reports.service.GenericResultData;

public interface ContentConverter {

    byte[] convert(final GenericResultData genericResultData);

}
