package com.vigorride.serviceImpl;

import org.springframework.stereotype.Service;

import com.vigorride.entity.Address;
import com.vigorride.entity.User;
import com.vigorride.exception.ConfirmPasswordNotMatchException;
import com.vigorride.exception.LoginCredentialsInvalidException;
import com.vigorride.exception.UserNotAgreedConditionException;
import com.vigorride.repository.AddressRepository;
import com.vigorride.repository.UserRepository;
import com.vigorride.request.LoginPayload;
import com.vigorride.request.SignUpPayload;
import com.vigorride.service.LoginService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final  UserRepository employeeRepository;
    private final AddressRepository  addressRepository;
	
    

	@Override
	public Boolean login(LoginPayload loginPayload) {
		// TODO Auto-generated method stub
		User employee=employeeRepository.findByEmail(loginPayload.getEmail());
		if(employee.getPassword().equals(loginPayload.getPassword())) {
			return true;
		}
		throw new LoginCredentialsInvalidException();
		
	}

	@Override
	public void signUp(SignUpPayload signUpPayload) {
		// TODO Auto-generated method stub
		CheckValidation(signUpPayload);
		User employee=User.builder().salutation(signUpPayload.getSalutation())
				         .firstName(signUpPayload.getFirstName()).lastName(signUpPayload.getLastName()).email(signUpPayload.getEmail())
				         .password(signUpPayload.getPassword()).dob(signUpPayload.getDob())
				         .build();
		employeeRepository.save(employee);
		Address homeAddress=signUpPayload.getHomeAddress();
		Address businessAddress=signUpPayload.getBusinessAddress();
	    if(businessAddress!=null)
		addressRepository.save(businessAddress);
	    if(homeAddress!=null)
		addressRepository.save(homeAddress);
		
	
	}

	public void CheckValidation(SignUpPayload signUpPayload){
		// TODO Auto-generated method stub
	
      if(!signUpPayload.getPassword().equals(signUpPayload.getConfirmPassword())) {
    	  throw new ConfirmPasswordNotMatchException(signUpPayload.getPassword());
      }
      if(!signUpPayload.getAgreeToProgramTermsAndConditions()||!signUpPayload.getAgreeToUniversalTermsOfService()) {
    	  throw new UserNotAgreedConditionException();
      }
      
		
	}
	
	

}
