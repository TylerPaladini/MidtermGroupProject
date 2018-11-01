package com.skilldistillery.babychanger.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.babychanger.data.UsersDAO;
import com.skilldistillery.babychanger.entities.Users;

@Controller
public class LoginController {

	@Autowired
	private UsersDAO usersDAO;

	/*
	 * Logs in the user
	 */
	@RequestMapping(path = "login.do", method = RequestMethod.POST)
	public ModelAndView userLogin(Users user, Errors errors, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String userName = user.getUserName();
		String password = user.getPassword();
		boolean userActive = usersDAO.isUserActive(user.getUserName());
		if (userActive) {
			Users loginUser = usersDAO.getUserByUsernameAndPassword(userName, password);
			if (loginUser != null) {
				session.setAttribute("loggedIn", loginUser);
				mv.setViewName("home");
			} else {
				mv.setViewName("login");
			}
		}
		else {
			mv.addObject("notCurrentUser", true);
			mv.setViewName("login");
		}
		return mv;
	}

	@RequestMapping(path = "logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("loggedIn");
		return "home";
	}

	@RequestMapping(path = "loginPage.do", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(path = "registerPage.do", method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("registerUserModel", new Users());
		return "register";
	}
}
