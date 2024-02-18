package com.vigorride.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SequenceGeneratorService {

    private final JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String generateNextSequence(String sequenceName, Long minValue){
        if (sequenceName != null){
            final Long count = this.jdbcTemplate.queryForObject("Select count(*) from sequences s where s.sequence_name =" 
            +"'" + sequenceName+ "'" , Long.class);
         if (count== null || count == 0){
            final String description = "Sequrnce for BC region " + sequenceName + "";

            this.jdbcTemplate.execute(
                 "INSERT INTO sequences ( sequence_name , increment_by , min_value , max_value , cur_value , is_reset_daily , sequence_date , description ) VALUES ('"
                  + sequenceName + "' , 1 ," + minValue + " ,9999999999999,"+minValue+", 0, null, '" + description + "')");
            }  
         return this.jdbcTemplate.queryForObject("SELECT generate_next_sequence('" + sequenceName + "')", String.class);

         
        }
        return this.jdbcTemplate
                .queryForObject("SELECT LPAD(( SELECT generate_next_sequence('" + sequenceName+")),15, '0')", String.class);

    }
    
}
