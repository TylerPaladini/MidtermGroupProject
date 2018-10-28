package com.skilldistillery.babychanger.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.babychanger.data.AddressDAO;
import com.skilldistillery.babychanger.data.CommentDAO;
import com.skilldistillery.babychanger.data.LocationDAO;
import com.skilldistillery.babychanger.data.RestroomDAO;
import com.skilldistillery.babychanger.data.UsersDAO;
import com.skilldistillery.babychanger.entities.Users;

@Controller
public class LoginController {

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

	
	// Logs in the user
		@RequestMapping(path = "login.do", method = RequestMethod.POST)
		public ModelAndView userLogin(Users user, HttpSession session) {
			ModelAndView mv = new ModelAndView();
			String userName = user.getUserName();
			String password = user.getPassword();
			
			Users loginUser = usersDAO.getUserByUsernameAndPassword(userName, password);
			
			if(loginUser != null ) {
				session.setAttribute("loggedIn", loginUser);
				mv.setViewName("home");
			}
			else {
				mv.setViewName("login");
			}
			return mv;
			
		}
		
		@RequestMapping ( path = "logout.do", method = RequestMethod.GET)
		public String logout( HttpSession session) {
			session.removeAttribute("loggedIn");
			return "home";
		}
		@RequestMapping ( path = "loginPage.do", method = RequestMethod.GET)
		public String loginPage() {
			return "login";
		}
		@RequestMapping ( path = "registerPage.do", method = RequestMethod.GET)
		public String registerPage() {
			return "register";
		}
		

}
