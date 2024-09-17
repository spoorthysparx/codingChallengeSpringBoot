package com.hexaware.web.Service;

import com.hexaware.web.Entity.SignupRequest;
import com.hexaware.web.Entity.User;

public interface AuthService {
	User createUser(SignupRequest signupRequest);

	boolean hasCustomerWithEmail(String email);

	
}
