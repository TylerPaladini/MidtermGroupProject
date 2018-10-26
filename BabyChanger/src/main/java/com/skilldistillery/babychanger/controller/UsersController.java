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
	public ModelAndView createUser( Users newUser) {
		ModelAndView mv = new ModelAndView();
		
		usersDAO.createUsers(newUser);
		mv.setViewName("redirect:createdUser.do");
		
		return mv;
	}
	
	@RequestMapping(path = "createdUser.do", method = RequestMethod.GET)
	public ModelAndView createdUser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profile.jsp");
		
		return mv;
		
	}
	
	// Update user profile
	
	@RequestMapping( path = "updateUser.do", method = RequestMethod.POST)
	public ModelAndView updateUser(Users updatedUser, int id) {
		ModelAndView mv = new ModelAndView();
		
		usersDAO.updateUsers(id, updatedUser);
		mv.setViewName("redirect:updatedUser.do");
		
		
		return mv;
	}
	
	@RequestMapping(path = "updatedUser.do", method = RequestMethod.GET)
	public ModelAndView updatedUser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profile.jsp");
		
		return mv;
	}
	// Disable user profile
	@RequestMapping(path = "disableUser.do", method = RequestMethod.POST)
	public ModelAndView disableUser(Users disableUser, int id) {
		ModelAndView mv = new ModelAndView();
		
		usersDAO.disableUser(id, disableUser);
		mv.setViewName("redirect:disabledUser.do");
		
		
		return mv;
	}
	
	@RequestMapping(path = "disabledUser.do", method = RequestMethod.GET)
	public ModelAndView disabledUser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profile.jsp");
		
		return mv;
		
	}
		
		
		
		
	
		
		
		
		
	

}
