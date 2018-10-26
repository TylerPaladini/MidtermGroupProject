package com.skilldistillery.babychanger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.babychanger.data.AddressDAO;
import com.skilldistillery.babychanger.data.CommentDAO;
import com.skilldistillery.babychanger.data.LocationDAO;
import com.skilldistillery.babychanger.data.RestroomDAO;
import com.skilldistillery.babychanger.data.UsersDAO;
import com.skilldistillery.babychanger.entities.Users;

@Controller
public class AdminController {

	@Autowired
	private AddressDAO addressDAO;
	@Autowired
	private CommentDAO commentDAO;
	@Autowired
	private LocationDAO locationDAO;
	@Autowired
	private RestroomDAO restroomDAO;
	@Autowired
	private UsersDAO usersDAO;

	// create new user

	@RequestMapping(path = "createUserAdmin.do", method = RequestMethod.POST)
	public ModelAndView createUserAdmin(Users newUser, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();

		Users userCreated = usersDAO.createUsers(newUser);
		redir.addFlashAttribute("user", userCreated);
		mv.setViewName("redirect:createdUserAdmin.do");

		return mv;
	}

	@RequestMapping(path = "createdUserAdmin.do", method = RequestMethod.GET)
	public ModelAndView createdUserAdmin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profile");

		return mv;

	}

	// Update user profile

	@RequestMapping(path = "updateUserAdmin.do", method = RequestMethod.POST)
	public ModelAndView updateUserAdmin(Users updatedUser, int id, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();

		Users userUpdated = usersDAO.updateUsers(id, updatedUser);
		redir.addFlashAttribute("user", userUpdated);
		mv.setViewName("redirect:updatedUserAdmin.do");

		return mv;
	}

	@RequestMapping(path = "updatedUserAdmin.do", method = RequestMethod.GET)
	public ModelAndView updatedUserAdmin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profile");

		return mv;
	}

	// Disable user profile
	@RequestMapping(path = "disableUserAdmin.do", method = RequestMethod.POST)
	public ModelAndView disableUserAdmin(int userId) {
		ModelAndView mv = new ModelAndView();

		usersDAO.disableUser(userId);
		mv.setViewName("redirect:disabledUserAdmin.do");

		return mv;
	}

	@RequestMapping(path = "disabledUserAdmin.do", method = RequestMethod.GET)
	public ModelAndView disabledUserAdmin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profile");

		return mv;

	}

	// comes here when admin has confirmed they are deleting
	// a profile completely from the Database and redirects
	// preventing refresh errors
	@RequestMapping(path = "confirmDeleteAdmin.do", method = RequestMethod.POST)
	public ModelAndView tryDeletingProfileFromDB(int userId, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		boolean deleteSuccess = usersDAO.deleteUsers(userId);
		redir.addFlashAttribute("deleteSuccess", deleteSuccess);
		mv.setViewName("redirect:deleteComplete.do");
		return mv;
	}

	// comes here when redirected from confirmDelete and confirms
	// to admin if delete was successful or not
	@RequestMapping(path = "deleteCompleteAdmin.do", method = RequestMethod.GET)
	public ModelAndView deleteProfileFromDBComplete() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("confirmation");
		return mv;
	}

}
