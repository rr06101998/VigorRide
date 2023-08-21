package com.vigorride.request;

import java.time.LocalDate;

import com.vigorride.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class LoginPayload {
       private String email;
       private String password;
}
