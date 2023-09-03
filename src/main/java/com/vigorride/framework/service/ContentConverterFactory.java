package com.vigorride.framework.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.vigorride.framework.enums.ContentType;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContentConverterFactory implements ApplicationContextAware {
    
    private ApplicationContext applicationContext;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
       this.applicationContext=applicationContext;
    }

    public ContentConverter getContentConverter(final ContentType contentType) {
        ContentConverter converter=null;
        switch(contentType){
            case PDF:
                  converter=this.applicationContext.getBean(CsvConverter.class);
            break;
            default:

            break;
        }
        return converter;
    }
    
}
