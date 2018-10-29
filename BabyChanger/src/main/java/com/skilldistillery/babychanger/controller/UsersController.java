package com.skilldistillery.babychanger.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.babychanger.data.AddressDAO;
import com.skilldistillery.babychanger.data.CommentDAO;
import com.skilldistillery.babychanger.data.LocationDAO;
import com.skilldistillery.babychanger.data.RestroomDAO;
import com.skilldistillery.babychanger.data.UsersDAO;
import com.skilldistillery.babychanger.data.UsersDAOImpl;
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

	// create new user

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
		mv.setViewName("profile");
		return mv;
	}

	// Update user profile

	@RequestMapping(path = "updateProfilePageUser.do", method = RequestMethod.GET)
	public String updateUserPage() {
		return "update";
	}

	@RequestMapping(path = "updateUser.do", method = RequestMethod.POST)
	public ModelAndView updateUser(Users updatedUser, int id, RedirectAttributes redir, HttpSession session) {
		ModelAndView mv = new ModelAndView();

		Users userUpdated = usersDAO.updateUsers(id, updatedUser);
		if (userUpdated != null) {
			session.setAttribute("loggedIn", userUpdated);
			redir.addFlashAttribute("user", userUpdated);
			mv.setViewName("redirect:updatedUser.do");
		} else {
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
		// Determine if there are any errors.
		if (errors.getErrorCount() != 0) {
			// If there are any errors, return the login form.
			mv.setViewName("add");
			mv.addObject("newEntry", true);
		}
		// If no errors, send the user forward to the profile view.
		else {
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

		ModelAndView mv = new ModelAndView();
		// Determine if there are any errors.
		if (errors.getErrorCount() != 0) {
			// If there are any errors, return the login form.
			mv.setViewName("add");
			mv.addObject("addLocationNext", true);
		}
		// If no errors, send the user forward to the profile view.
		else {
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
		
		// Determine if there are any errors.
		if (errors.getErrorCount() != 0) {
			// If there are any errors, return the login form.
			mv.setViewName("add");
			mv.addObject("addRestroomNext", true);
		}
		// If no errors, send the user forward to the profile view.
		else {
			Address newAddress = (Address) session.getAttribute("newAddress");
			Location newLocation = (Location) session.getAttribute("newLocation");

			Address addedAddress = addressDAO.createAddress(newAddress);

			newLocation.setAddress(addedAddress);
			Location addedLocation = locationDAO.createLocation(newLocation);

			addedLocation.addRestroom(restroom);
			restroom.setUserId(userId);

			Restroom addedRestroom = restroomDAO.createRestroom(restroom);

			boolean addSuccess = addedRestroom != null && addedLocation != null && addedAddress != null;

			mv.addObject("addSuccess", addSuccess);
			mv.setViewName("confirmation");
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
		Location updateLocation = locationDAO.getLocationById(id);

		ModelAndView mv = new ModelAndView();
		mv.addObject("updateLocation", updateLocation);
		mv.setViewName("update");
		return mv;
	}

	// User updates previous location
	@RequestMapping(path = "userUpdateLocationUser.do", method = RequestMethod.POST)
	public ModelAndView userUpdateLocation(int id, Address address, Location location, RedirectAttributes redir,
			HttpSession session) {
		ModelAndView mv = new ModelAndView();

		Location newUpdatedLocation = locationDAO.updateLocation(id, location);
		if (newUpdatedLocation != null) {
			session.setAttribute("updatedLocation", newUpdatedLocation);
			redir.addFlashAttribute("updatedLocation", newUpdatedLocation);
			mv.setViewName("userUpdatedLocationUser.do");
		} else {
			mv.setViewName("update");
		}
		return mv;
	}

	@RequestMapping(path = "userUpdatedLocationUser.do", method = RequestMethod.GET)
	public ModelAndView updatedLocation() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("update");

		return mv;
	}

	// Adds comment
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
	public ModelAndView addComment(Comment comment, RedirectAttributes redir, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		comment.setUser((Users) session.getAttribute("loggedIn"));
		comment.setRestroom((Restroom) session.getAttribute("commentedRestroom"));
		comment.setDateCreated(new Date());
		Comment addcomment = commentDAO.addComment(comment);
		redir.addFlashAttribute("addComment", addcomment);
		mv.setViewName("redirect:addedCommentAdmin.do");

		return mv;

	}

	@RequestMapping(path = "addedCommentUser.do", method = RequestMethod.GET)
	public ModelAndView addedComment() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("commentAdded", true);
		mv.setViewName("confirmation");

		return mv;

	}

	// user updates comment
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
		mv.setViewName("redirect:addedCommentAdmin.do");

		return mv;

	}

	@RequestMapping(path = "updatedCommentUser.do", method = RequestMethod.GET)
	public ModelAndView updatedComment() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("confirmation");

		return mv;

	}

}
