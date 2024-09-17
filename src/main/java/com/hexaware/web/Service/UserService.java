package com.hexaware.web.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	UserDetailsService userDetailsService();
}
