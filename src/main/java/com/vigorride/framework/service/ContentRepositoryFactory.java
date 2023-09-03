package com.vigorride.framework.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.vigorride.framework.repository.ContentRepository;
import com.vigorride.framework.repository.FileSystemContentRepository;

@Service
public class ContentRepositoryFactory implements ApplicationContextAware{
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
       this.applicationContext=applicationContext;
    }

    public ContentRepository getRepository() {
        return applicationContext.getBean(FileSystemContentRepository.class);
    }
    
}
