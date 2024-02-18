package com.vigorride.sequence.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SequenceConfigRepositoryWrapper {
	
    @Autowired
	private SequenceConfigRepository sequenceConfigRepository;

    public  SequenceConfig getBySequenceType(String sequenceType) {
        return this.sequenceConfigRepository.getBySequenceType(sequenceType);
    }

	
}