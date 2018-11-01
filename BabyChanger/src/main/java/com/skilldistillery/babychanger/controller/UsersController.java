package com.skilldistillery.babychanger.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.babychanger.data.AddressDAO;
import com.skilldistillery.babychanger.data.CommentDAO;
import com.skilldistillery.babychanger.data.LocationDAO;
import com.skilldistillery.babychanger.data.RestroomDAO;
import com.skilldistillery.babychanger.data.UsersDAO;
import com.skilldistillery.babychanger.entities.Address;
import com.skilldistillery.babychanger.entities.Comment;
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

	/*
	 * create new user
	 */
	@RequestMapping(path = "createUser.do", method = RequestMethod.POST)
	public ModelAndView createUser(@Valid @ModelAttribute("registerUserModel") Users user, Errors errors,
			RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		// Determine if there are any errors.
		if (errors.getErrorCount() != 0) {
			// If there are any errors, return the login form.
			mv.setViewName("register");
		} else if (usersDAO.userDoesExist(user.getUserName())) {
			errors.rejectValue("userName", "error.userName", "This user name is unavailable");
			mv.setViewName("register");
		}
		// If no errors, send the user forward to the profile view.
		else {
			Users userCreated = usersDAO.createUsers(user);
			redir.addFlashAttribute("userCreated", userCreated);
			mv.setViewName("redirect:createdUser.do");
		}
		return mv;
	}

	@RequestMapping(path = "createdUser.do", method = RequestMethod.GET)
	public ModelAndView createdUser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}

	// implements a test for the update.jsp to test if user update profile is being
	// passed in
	// if it is not true it will not show the update profile options.
	@RequestMapping(path = "updateProfilePageUser.do", method = RequestMethod.GET)
	public ModelAndView updateUserPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("updatedUser", true);
		mv.setViewName("update");

		return mv;
	}

	/*
	 * Update user profile
	 */
	@RequestMapping(path = "updateUser.do", method = RequestMethod.POST)
	public ModelAndView updateUser(Users updatedUser, int id, RedirectAttributes redir, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Users userUpdated = usersDAO.updateUsers(id, updatedUser);
		if (userUpdated != null) {
			session.setAttribute("loggedIn", userUpdated);
			redir.addFlashAttribute("user", userUpdated);
		} else {
			redir.addFlashAttribute("updateUserFailed", true);
		}
		mv.setViewName("redirect:updatedUser.do");
		return mv;
	}

	@RequestMapping(path = "updatedUser.do", method = RequestMethod.GET)
	public ModelAndView updatedUser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profile");
		mv.addObject("profileUpdateSuccess", true);
		return mv;
	}

	// Disable user profile
	@RequestMapping(path = "disableUser.do", method = RequestMethod.GET)
	public ModelAndView disableUser(int userId) {
		ModelAndView mv = new ModelAndView();
		usersDAO.disableUser(userId);
		mv.setViewName("redirect:disabledUser.do");
		return mv;
	}

	@RequestMapping(path = "disabledUser.do", method = RequestMethod.GET)
	public ModelAndView disabledUser(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.removeAttribute("loggedIn");
		mv.setViewName("home");
		return mv;
	}

	/*
	 * add location
	 * see admin controller for explanation
	 */
	@RequestMapping(path = "userAddsAddressLocationRestroom.do")
	public ModelAndView addAddressLocationRestroom() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("createAddressModel", new Address());
		mv.addObject("newEntry", true);
		mv.setViewName("add");
		return mv;
	}

	@RequestMapping(path = "userAddsAddress.do", method = RequestMethod.POST)
	public ModelAndView userAddsAddress(@Valid @ModelAttribute("createAddressModel") Address address, Errors errors,
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (errors.getErrorCount() != 0) {
			mv.setViewName("add");
			mv.addObject("newEntry", true);
		} else {
			session.setAttribute("newAddress", address);
			mv.addObject("addLocationNext", true);
			mv.addObject("createLocationModel", new Location());
			mv.setViewName("add");
		}
		return mv;
	}

	@RequestMapping(path = "userAddsLocation.do", method = RequestMethod.POST)
	public ModelAndView userAddsLocation(@Valid @ModelAttribute("createLocationModel") Location location, Errors errors,
			HttpSession session) {
		System.out.println(location.toString());
		ModelAndView mv = new ModelAndView();
		if (errors.getErrorCount() != 0) {
			mv.setViewName("add");
			mv.addObject("addLocationNext", true);
		} else {
			session.setAttribute("newLocation", location);
			mv.addObject("addRestroomNext", true);
			mv.addObject("createRestroomModel", new Restroom());
			mv.setViewName("add");
		}
		return mv;
	}

	@RequestMapping(path = "userAddsRestroom.do", method = RequestMethod.POST)
	public ModelAndView userAddsRestroom(@Valid @ModelAttribute("createRestroomModel") Restroom restroom, Errors errors,
			HttpSession session, int userId) {
		ModelAndView mv = new ModelAndView();
		if (errors.getErrorCount() != 0) {
			mv.setViewName("add");
			mv.addObject("addRestoomNext", true);
		} else {
			Address newAddress = (Address) session.getAttribute("newAddress");
			Location newLocation = (Location) session.getAttribute("newLocation");
			newLocation.setAddress(newAddress);
			Location addedLocation = locationDAO.createLocation(newLocation);
			addedLocation.addRestroom(restroom);
			restroom.setUserId(userId);
			Restroom addedRestroom = restroomDAO.createRestroom(restroom);
			boolean addSuccess = addedRestroom != null && addedLocation != null && newAddress != null;
			Double averageRating = locationDAO.getAverageRating(addedLocation.getId());
			mv.addObject("location", addedLocation);
			mv.addObject("averageRating", averageRating);
			mv.addObject("addLocationSuccess", addSuccess);
			mv.setViewName("detailedResults");
		}
		return mv;
	}

	@RequestMapping(path = "profileUser.do", method = RequestMethod.GET)
	public ModelAndView goToUserProfile() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profile");
		return mv;
	}

	// Maps user to update.jsp to update a location
	@RequestMapping(path = "userUpdateLocation.do", method = RequestMethod.GET)
	public ModelAndView goToUpdatePage(int id) {
		ModelAndView mv = new ModelAndView();
		Location updateLocation = locationDAO.getLocationById(id);
		mv.addObject("updateLocation", updateLocation);
		mv.addObject("userUpdateLocationModel", new Location());
		mv.addObject("userUpdatingLocation", true);
		mv.setViewName("update");
		return mv;
	}

	// User updates previous location
	@RequestMapping(path = "userUpdateLocationUser.do", method = RequestMethod.POST)
	public ModelAndView userUpdateLocation(@Valid @ModelAttribute("userUpdateLocation") Location location,
			Errors errors, @RequestParam("locationId") int locationId, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (errors.getErrorCount() != 0) {
			mv.setViewName("update");
			mv.addObject("updatingLocation", true);
		} else {
			location.setId(locationId);
			session.setAttribute("updatedLocation", location);
			Address updateAddress = locationDAO.getLocationById(locationId).getAddress();
			mv.addObject("updateAddress", updateAddress);
			mv.addObject("userUpdateAddressModel", new Address());
			mv.addObject("userUpdateAddressNext", true);
			mv.setViewName("update");
		}
		return mv;
	}

	@RequestMapping(path = "userUpdateAddressUser.do", method = RequestMethod.POST)
	public ModelAndView userUpdatedLocation(@Valid @ModelAttribute("userUpdateAddressModel") Address address,
			Errors errors, @RequestParam("addressId") int addressId, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (errors.getErrorCount() != 0) {
			mv.setViewName("update");
			mv.addObject("updateAddressNext", true);
		} else {
			Location updatedLocation = (Location) session.getAttribute("updatedLocation");
			address.setId(addressId);
			updatedLocation.setAddress(address);
			Location locationUpdate = locationDAO.updateLocation(updatedLocation.getId(), updatedLocation, address);
			Double averageRating = locationDAO.getAverageRating(locationUpdate.getId());
			mv.addObject("locationUpdateSuccess", true);
			mv.addObject("location", locationUpdate);
			mv.addObject("averageRating", averageRating);
			mv.setViewName("detailedResults");
		}
		return mv;
	}

	/*
	 *  Adds comment
	 */
	@RequestMapping(path = "addedCommentPageUser.do", method = RequestMethod.GET)
	public ModelAndView goToAddCommentPage(int restroomId, HttpSession session) {
		Restroom commentedRestroom = restroomDAO.getRestroom(restroomId);
		session.setAttribute("commentedRestroom", commentedRestroom);
		ModelAndView mv = new ModelAndView();
		mv.addObject("addingComment", true);
		mv.setViewName("add");
		return mv;
	}

	@RequestMapping(path = "addCommentUser.do", method = RequestMethod.POST)
	public ModelAndView addComment(Comment comment,  RedirectAttributes redir, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		comment.setUser((Users) session.getAttribute("loggedIn"));
		comment.setRestroom((Restroom) session.getAttribute("commentedRestroom"));
		comment.setDateCreated(new Date());
		Comment addComment = commentDAO.addComment(comment);
		commentDAO.editComment(addComment.getId(), addComment);
		int locationId = addComment.getRestroom().getLocation().getId();
		Double averageRating = locationDAO.getAverageRating(locationId);
		redir.addFlashAttribute("location", locationDAO.getLocationById(locationId));
		redir.addFlashAttribute("averageRating", averageRating);
		mv.setViewName("redirect:addedCommentUser.do");
		return mv;
	}

	@RequestMapping(path = "addedCommentUser.do", method = RequestMethod.GET)
	public ModelAndView addedComment() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("commentAdded", true);
		mv.setViewName("detailedResults");
		return mv;
	}

	/*
	 * user updates comment
	 */
	@RequestMapping(path = "updateCommentPageUser.do", method = RequestMethod.GET)
	public ModelAndView goToUpdateCommentPage(int commentId, HttpSession session) {
		Comment updatedComment = commentDAO.findCommentById(commentId);
		session.setAttribute("updatedComment", updatedComment);
		ModelAndView mv = new ModelAndView();
		mv.addObject("updatingComment", true);
		mv.setViewName("update");
		return mv;

	}

	@RequestMapping(path = "updateCommentUser.do", method = RequestMethod.POST)
	public ModelAndView updateComment(Comment comment, RedirectAttributes redir, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		int commentId = ((Comment) session.getAttribute("updatedComment")).getId();
		comment.setDateCreated(new Date());
		Comment newUpdatedComment = commentDAO.editComment(commentId, comment);
		int locationId = newUpdatedComment.getRestroom().getLocation().getId();
		Double averageRating = locationDAO.getAverageRating(locationId);
		redir.addFlashAttribute("location",  locationDAO.getLocationById(locationId));
		redir.addFlashAttribute("averageRating", averageRating);
		mv.setViewName("redirect:updatedCommentUser.do");
		return mv;
	}

	@RequestMapping(path = "updatedCommentUser.do", method = RequestMethod.GET)
	public ModelAndView updatedComment() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("updateComment", true);
		mv.setViewName("detailedResults");
		return mv;
	}

	/*
	 * Disables comments made by a user
	 */
	@RequestMapping(path = "disableCommentUser.do", method = RequestMethod.POST)
	public ModelAndView disableComment(int id, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		commentDAO.disableComment(id);
		int locationId = commentDAO.findCommentById(id).getRestroom().getLocation().getId();
		Double averageRating = locationDAO.getAverageRating(locationId);
		redir.addFlashAttribute("location", locationDAO.getLocationById(locationId));
		redir.addFlashAttribute("averageRating", averageRating);
		mv.setViewName("redirect:disabledCommentUser.do");
		return mv;
	}

	@RequestMapping(path = "disabledCommentUser.do", method = RequestMethod.GET)
	public ModelAndView disabledComment() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("disabledComment", true);
		mv.setViewName("detailedResults");
		return mv;
	}

	/*
	 * Marks comment with flag (true/false)
	 */
	@RequestMapping(path = "updateFlagCommentUser.do", method = RequestMethod.POST)
	public ModelAndView updateFlag(int id, boolean isFlag, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		commentDAO.updateFlag(id, isFlag);
		int locationId = commentDAO.findCommentById(id).getRestroom().getLocation().getId();
		Double averageRating = locationDAO.getAverageRating(locationId);
		redir.addFlashAttribute("location", locationDAO.getLocationById(locationId));
		redir.addFlashAttribute("averageRating", averageRating);
		mv.setViewName("redirect:updatedFlagCommentUser.do");
		return mv;
	}

	@RequestMapping(path = "updatedFlagCommentUser.do", method = RequestMethod.GET)
	public ModelAndView updatedFlag() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("detailedResults");
		mv.addObject("flaggedComment", true);
		return mv;
	}

	@RequestMapping(path = "flagRestroom.do", method = RequestMethod.POST)
	public ModelAndView updateFlagRestroom(int id, boolean isFlag, String flaggedReason, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		restroomDAO.updateFlag(id, isFlag, flaggedReason);
		Double averageRating = locationDAO.getAverageRating(restroomDAO.getRestroom(id).getLocation().getId());
		redir.addFlashAttribute("location", restroomDAO.getRestroom(id).getLocation());
		redir.addFlashAttribute("averageRating", averageRating);
		mv.setViewName("redirect:updatedFlagRestroom.do");
		return mv;
	}

	@RequestMapping(path = "updatedFlagRestroom.do", method = RequestMethod.GET)
	public ModelAndView updatedFlagRestroom() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("restroomFlagged", true);
		
		mv.setViewName("detailedResults");
		return mv;
	}

	/*
	 * Maps user to update.jsp to update a location
	 */
	@RequestMapping(path = "userUpdateRestroom.do", method = RequestMethod.GET)
	public ModelAndView goToUpdateRestroom(@RequestParam("restroomId") int restroomId,
			@RequestParam("locationId") int locationId, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Restroom updateRestroom = restroomDAO.getRestroom(restroomId);
		session.setAttribute("locationId", locationId);
		mv.addObject("updateRestroom", updateRestroom);
		mv.addObject("userUpdateRestroomModel", new Restroom());
		mv.addObject("userUpdatingRestroom", true);
		mv.setViewName("update");
		return mv;
	}

	@RequestMapping(path = "userUpdateRestroomUser.do", method = RequestMethod.POST)
	public ModelAndView userUpdateRestroom(@Valid @ModelAttribute("userUpdateRestroomModel") Restroom restroom,
			Errors errors, @RequestParam("restroomId") int restroomId, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (errors.getErrorCount() != 0) {
			mv.setViewName("update");
			mv.addObject("updatingRestroom", true);
		} else {
			restroomDAO.updateRestroom(restroomId, restroom);
			Integer updatedRestroomAtLocation = (Integer) session.getAttribute("locationId");
			Location locationById = locationDAO.getLocationById(updatedRestroomAtLocation);
			Double averageRating = locationDAO.getAverageRating(locationById.getId());
			mv.addObject("location", locationById);
			mv.addObject("averageRating", averageRating);
			mv.setViewName("detailedResults");
		}
		return mv;
	}
	
	/*
	 * attempt to see if we could get the time functionality to work
	 */
	@InitBinder("userUpdateLocationModel")
	public void customizedTimeFormat(WebDataBinder binder) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm");
		binder.registerCustomEditor(Date.class, "openTime", new CustomDateEditor(dateFormatter, true));
	}
}
