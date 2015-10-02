package com.rakuten.productMgmt.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import com.rakuten.productMgmt.entities.User;
import com.rakuten.productMgmt.services.UserService;
import com.rakuten.productMgmt.web.config.SecurityUser;

@Controller
public class UserController {
	
	private static UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		UserController.userService = userService;
	}

	public static User getCurrentUser() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			String email = ((UserDetails) principal).getUsername();
			User loginUser = userService.findUserByEmail(email);
			return new SecurityUser(loginUser);
		}

		return null;
	}
}