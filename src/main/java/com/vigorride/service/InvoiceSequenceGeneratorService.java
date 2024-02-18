package com.vigorride.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.vigorride.sequence.entity.SequenceConfig;
import com.vigorride.sequence.entity.SequenceConfigRepositoryWrapper;
import com.vigorride.sequence.entity.SequenceType;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InvoiceSequenceGeneratorService {

    private final SequenceGeneratorService sequenceGeneratorService;
    private final SequenceConfigRepositoryWrapper sequenceConfigRepositoryWrapper;


    public String generateInvoiceNumber(){

    SequenceConfig sequenceConfig = this.sequenceConfigRepositoryWrapper.getBySequenceType(SequenceType.INVOICE.name());
    String config = sequenceConfig.getConfig();
    String[] splitStrings = config.split("_");
    Set<String> resultSet = new HashSet<>(Arrays.asList(splitStrings));

    StringBuilder sequence = new StringBuilder();

    // Iterate through the set and append each element present in resultSet
    for (String element : Arrays.asList("charge", "date")) {
        if (resultSet.contains(element)) {
            sequence.append(element);
        }
    }

    sequence.append(sequenceGeneratorService.generateNextSequence(sequence.toString(), 500L));

    return sequence.toString();
    }
    
}
