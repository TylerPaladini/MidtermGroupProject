package com.skilldistillery.babychanger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.babychanger.data.UsersDAO;
import com.skilldistillery.babychanger.entities.Users;

@Controller
public class UsersController {
	@Autowired
	private UsersDAO usersDAO;
	
	// create new user
	
	@RequestMapping(path = "createUser.do", method = RequestMethod.POST)
	public ModelAndView createUser( Users newUser, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		
		Users userCreated = usersDAO.createUsers(newUser);
		redir.addFlashAttribute("user", userCreated);
		mv.setViewName("redirect:createdUser.do");
		
		return mv;
	}
	
	@RequestMapping(path = "createdUser.do", method = RequestMethod.GET)
	public ModelAndView createdUser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profile");
		
		return mv;
		
	}
	
	// Update user profile
	
	@RequestMapping( path = "updateUser.do", method = RequestMethod.POST)
	public ModelAndView updateUser(Users updatedUser, int id, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		
		
		Users userUpdated = usersDAO.updateUsers(id, updatedUser);
		redir.addFlashAttribute("user", userUpdated);
		mv.setViewName("redirect:updatedUser.do");
		
		
		return mv;
	}
	
	@RequestMapping(path = "updatedUser.do", method = RequestMethod.GET)
	public ModelAndView updatedUser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profile");
		
		return mv;
	}
	// Disable user profile
	@RequestMapping(path = "disableUser.do", method = RequestMethod.POST)
	public ModelAndView disableUser(int userId) {
		ModelAndView mv = new ModelAndView();
		
		usersDAO.disableUser(userId);
		mv.setViewName("redirect:disabledUser.do");
		
		
		return mv;
	}
	
	@RequestMapping(path = "disabledUser.do", method = RequestMethod.GET)
	public ModelAndView disabledUser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profile");
		
		return mv;
		
	}
		
	@RequestMapping(path="addAddressLocationRestroom.do")
	public ModelAndView addAddressLocationRestroom() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("add");
		return mv;
	}
		
		
	
		
		
		
		
	

}
