package com.skilldistillery.babychanger.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.babychanger.data.AddressDAO;
import com.skilldistillery.babychanger.data.CommentDAO;
import com.skilldistillery.babychanger.data.LocationDAO;
import com.skilldistillery.babychanger.data.RestroomDAO;
import com.skilldistillery.babychanger.data.UsersDAO;
import com.skilldistillery.babychanger.entities.Address;
import com.skilldistillery.babychanger.entities.Location;
import com.skilldistillery.babychanger.entities.Restroom;
import com.skilldistillery.babychanger.entities.Users;

@Controller
public class UsersController {
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
	
	@RequestMapping(path = "createUser.do", method = RequestMethod.POST)
//	public ModelAndView createUser(@Valid Users user, Errors errors, RedirectAttributes redir) {
	public ModelAndView createUser(Users user, Errors errors, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		
		// Determine if there are any errors.
	    if (errors.getErrorCount() != 0) {
	      // If there are any errors, return the login form.
	      mv.setViewName("register");
	    }
	    // If no errors, send the user forward to the profile view.
	    else {
	    	Users userCreated = usersDAO.createUsers(user);
			redir.addFlashAttribute("user", userCreated);
			mv.setViewName("redirect:createdUser.do");
	    }
		return mv;
	}
	
	@RequestMapping(path = "createdUser.do", method = RequestMethod.GET)
	public ModelAndView createdUser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profile");
		return mv;
	}
	
	// Update user profile
	
	
	@RequestMapping( path = "updateProfilePageUser.do", method = RequestMethod.GET)
	public String updateUserPage() {
		return "update";
	}
	
	@RequestMapping( path = "updateUser.do", method = RequestMethod.POST)
	public ModelAndView updateUser( Users updatedUser, int id, RedirectAttributes redir, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		
		Users userUpdated = usersDAO.updateUsers(id, updatedUser);
		if(userUpdated != null) {
			session.setAttribute("loggedIn", userUpdated);
			redir.addFlashAttribute("user", userUpdated);
			mv.setViewName("redirect:updatedUser.do");
		}
		else {
			mv.setViewName("confirmation"); 
		}
		
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
		
	@RequestMapping(path="userAddsAddressLocationRestroom.do")
	public ModelAndView addAddressLocationRestroom() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("newEntry", true);
		mv.setViewName("add");
		return mv;
	}
	
	@RequestMapping(path="userAddsAddress.do", method = RequestMethod.POST)
	public ModelAndView userAddsAddress( Address address, HttpSession session) {
		
		session.setAttribute("newAddress", address);
		ModelAndView mv = new ModelAndView();
		mv.addObject("addLocationNext", true);
		mv.setViewName("add");
		return mv;
	}
	@RequestMapping(path="userAddsLocation.do", method = RequestMethod.POST)
	public ModelAndView userAddsLocation( Location location, HttpSession session) {
		session.setAttribute("newLocation", location);
		ModelAndView mv = new ModelAndView();
		mv.addObject("addRestroomNext", true);
		mv.setViewName("add");
		return mv;
	}
	@RequestMapping(path="userAddsRestroom.do", method = RequestMethod.POST)

	public ModelAndView userAddsRestroom(HttpSession session, int userId, Restroom restroom) {

		
		Address newAddress = (Address) session.getAttribute("newAddress");
		Location newLocation = (Location) session.getAttribute("newLocation");
		
		Address addedAddress = addressDAO.createAddress(newAddress);
		
		newLocation.setAddress(addedAddress);
		Location addedLocation = locationDAO.createLocation(newLocation);
		
		
		
		addedLocation.addRestroom(restroom);
		restroom.setUserId(userId);
		
		Restroom addedRestroom = restroomDAO.createRestroom(restroom);
		
		boolean addSuccess = addedRestroom != null && addedLocation != null && addedAddress != null  ;
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("addSuccess", addSuccess);
		mv.setViewName("confirmation");
		return mv;
	}
	
	@RequestMapping(path="profileUser.do", method = RequestMethod.GET)
	public ModelAndView goToUserProfile() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profile");
		return mv;
	}
	

}
