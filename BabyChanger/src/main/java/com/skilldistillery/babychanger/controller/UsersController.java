package com.skilldistillery.babychanger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.babychanger.data.UsersDAO;
import com.skilldistillery.babychanger.entities.Users;

@Controller
public class UsersController {
	@Autowired
	private UsersDAO usersDAO;
	
	// create new user
	
	@RequestMapping(path = "createUser.do", method = RequestMethod.POST)
	public ModelAndView createUser( Users users) {
		
		
		
		
		return mv;
		
	}
	

}
