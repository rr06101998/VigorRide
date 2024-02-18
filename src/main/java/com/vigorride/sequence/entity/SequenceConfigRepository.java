package com.vigorride.sequence.entity;


import org.springframework.data.jpa.repository.JpaRepository;

public interface SequenceConfigRepository extends JpaRepository<SequenceConfig, Long>{

    SequenceConfig getBySequenceType(String sequenceType);

}

