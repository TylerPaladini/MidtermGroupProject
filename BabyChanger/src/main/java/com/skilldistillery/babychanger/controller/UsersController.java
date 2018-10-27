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
		mv.addObject("newEntry", true);
		mv.setViewName("add");
		return mv;
	}
	
	@RequestMapping(path="userAddsAddress.do", method = RequestMethod.POST)
	public ModelAndView userAddsAddress(Address address) {
		Address newAddress = addressDAO.createAddress(address);
		boolean addLocationNext = newAddress != null;
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("addLocationNext", addLocationNext);
		mv.addObject("newAddress", newAddress);
		mv.setViewName("add");
		return mv;
	}
	@RequestMapping(path="userAddsLocation.do", method = RequestMethod.POST)
	public ModelAndView userAddsLocation( Location location) {
		Address previousAddressAdded = addressDAO.getAddressById(1);
		location.setAddress(previousAddressAdded);
		
		Location newLocation = locationDAO.createLocation(location);
		boolean addRestroomNext = newLocation != null;
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("addRestroomNext", addRestroomNext);
		mv.addObject("newLocation", newLocation);
		mv.setViewName("add");
		return mv;
	}
	@RequestMapping(path="userAddsRestroom.do", method = RequestMethod.POST)
	public ModelAndView userAddsRestroom(int locationId, Restroom restroom) {
		Location newLocation = locationDAO.getLocationById(locationId);
		newLocation.addRestroom(restroom);
		locationDAO.updateLocation(locationId, newLocation);
	
		Restroom newRestroom = restroomDAO.createRestroom(restroom);
		
		boolean addSuccess = newRestroom != null;
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("addSuccess", addSuccess);
		mv.setViewName("confirmation");
		return mv;
	}
	
	
		
	
		
		
		
		
	

}
