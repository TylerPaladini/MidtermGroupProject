package com.skilldistillery.babychanger.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public ModelAndView createUserAdmin( Users newUser, RedirectAttributes redir) {
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
	
	@RequestMapping( path = "updateProfilePageAdmin.do", method = RequestMethod.GET)
	public String updateAdminPage() {
		return "update";
	}

	@RequestMapping(path = "updateUserAdmin.do", method = RequestMethod.POST)
	public ModelAndView updateUserAdmin( Users updatedUser, int id, RedirectAttributes redir, HttpSession session) {
		ModelAndView mv = new ModelAndView();

		Users userUpdated = usersDAO.updateUsers(id, updatedUser);
		if(userUpdated != null) {
			session.setAttribute("loggedIn", userUpdated);
			redir.addFlashAttribute("user", userUpdated);
			mv.setViewName("redirect:updatedUserAdmin.do");
		}
		else {
			mv.setViewName("confirmation"); 
		}
		
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
		mv.setViewName("redirect:deleteCompleteAdmin.do");
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
	@RequestMapping(path = "getAllUsersAdmin.do", method = RequestMethod.GET)
	public ModelAndView getAllUsersAdmin() {
		ModelAndView mv = new ModelAndView();
		List<Users> allUsers = usersDAO.listAllUsers();
		mv.addObject("allUsers", allUsers);
		mv.setViewName("results");
		return mv;
	}
	
	// Disables comments made by a user
	@RequestMapping( path = "disableComment.do", method = RequestMethod.POST)
	public ModelAndView disableComment(int id) {
		ModelAndView mv = new ModelAndView();
		
		commentDAO.disableComment(id);
		mv.setViewName("redirect:disabledComment");
		
		return mv;
	}
	@RequestMapping(path = "disabledComment.do", method = RequestMethod.GET)
	public ModelAndView disabledComment() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("confirmation");
		
		return mv;
		
	}
	// Enables comments by a user
	@RequestMapping(path = "enableComment.do", method = RequestMethod.POST)
	public ModelAndView enableComment(int id) {
		ModelAndView mv = new ModelAndView();
		
		commentDAO.enableComment(id);
		mv.setViewName("redirect:enabledComment");
		
		return mv;
		
	}
	
	@RequestMapping(path = "enabledComment.do", method = RequestMethod.GET)
	public ModelAndView enabledComment() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("confirmation");
		
		return mv;
		
	}
	// Permanently deletes comment by a user from the database
	@RequestMapping(path = "deleteComment.do", method = RequestMethod.POST)
	public ModelAndView deleteComment(int id) {
		ModelAndView mv = new ModelAndView();
		
		commentDAO.deleteComment(id);
		mv.setViewName("redirect:deletedComment");
		
		return mv;
		
	}
	@RequestMapping(path = "deletedComment.do", method = RequestMethod.GET)
	public ModelAndView deletedComment() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("confirmation");
		
		return mv;
	}
	// Marks comment with flag (true/false) 
	@RequestMapping(path = "updateFlagComment.do", method = RequestMethod.POST)
	public ModelAndView updateFlag(int id, boolean isFlag) {
		ModelAndView mv = new ModelAndView();
		
		commentDAO.updateFlag(id, isFlag);
		mv.setViewName("redirect:updatedFlagComment");
		
		return mv;
	}
	@RequestMapping(path = "updatedFlagComment.do", method = RequestMethod.GET)
	public ModelAndView updatedFlag() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("confirmation");
		
		return mv;
	}
	
	// Adds comment
	@RequestMapping(path = "addedCommentPageAdmin.do", method = RequestMethod.GET)
	public ModelAndView goToAddCommentPage(int restroomId, HttpSession session) {
		Restroom commentedRestroom = restroomDAO.getRestroom(restroomId);
		session.setAttribute("commentedRestroom", commentedRestroom);
		ModelAndView mv = new ModelAndView();
		mv.addObject("addingComment", true);
		mv.setViewName("add");	
		return mv;
		
	}
	
	@RequestMapping(path = "addCommentAdmin.do", method = RequestMethod.POST)
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
	@RequestMapping(path = "addedCommentAdmin.do", method = RequestMethod.GET)
	public ModelAndView addedComment() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("commentAdded", true);
		mv.setViewName("confirmation");
		
		return mv;
		
	}
	// Edits a previous comment 
	@RequestMapping(path = "editComment.do", method = RequestMethod.POST)
	public ModelAndView editComment(int id, Comment comment, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		
		Comment editComment = commentDAO.editComment(id, comment);
		redir.addFlashAttribute("editComment", editComment);
		mv.setViewName("redirect:editedComment");
		
		return mv;
	}
	
	@RequestMapping(path = "editedComment.do", method = RequestMethod.GET)
	public ModelAndView editedComment() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("confirmtion");
		
		return mv;
	}
	
	// Finds a comment with the comment ID
	@RequestMapping(path = "findComment.do", method = RequestMethod.GET)
	public ModelAndView findCommitById(int id) {
		ModelAndView mv = new ModelAndView();
		
		Comment comment = commentDAO.findCommentById(id);
		mv.addObject("comment", comment);
		mv.setViewName("results");
		
		return mv;
		
	}
	// Finds a comment using the User ID
	@RequestMapping(path = "findCommentsByUserIdComment.do", method = RequestMethod.GET)
	public ModelAndView findCommentByUserId(int id) {
		ModelAndView mv = new ModelAndView();
		
		List<Comment> comments = commentDAO.findCommentsByUserId(id);
		
		mv.addObject("comments", comments);
		mv.setViewName("results");
		
		return mv;
	}
	
	//Finds a comment by Restroom iD
	@RequestMapping(path = "findCommentsByRestroomIdComment.do", method = RequestMethod.GET)
	public ModelAndView findCommentsByRestroomId(int id) {
		ModelAndView mv = new ModelAndView();
		
		List<Comment> comments = commentDAO.findCommentsByRestroomId(id);
		
		mv.addObject("comments", comments);
		mv.setViewName("results");
		
		return mv;
	}
	
	//Finds comment by a comment (string)
	@RequestMapping(path = "findCommentsByComments.do", method = RequestMethod.GET)
	public ModelAndView findCommentsByComment(String comment) {
		ModelAndView mv = new ModelAndView();
		
		List<Comment> comments = commentDAO.findCommentsByComment(comment);
		
		mv.addObject("comments", comments);
		mv.setViewName("results");
		
		return mv;
	}
	
	//Finds comments by Flagged comments
	@RequestMapping( path = "findCommnetsByFlaggedComment.do", method = RequestMethod.GET)
	public ModelAndView findCommentsByFlaggedComment(Boolean flag) {
		ModelAndView mv = new ModelAndView();
		
		List<Comment> comments = commentDAO.findCommentsByFlagComment(flag);
		
		mv.addObject("comments", comments);
		mv.setViewName("results");
		
		return mv;
	}
	
	// Finds comments by their rating
	@RequestMapping(path = "findCommentsByRatingComment.do", method = RequestMethod.GET)
	public ModelAndView findCommentsByRating(int rating) {
		ModelAndView mv = new ModelAndView();
		
		List<Comment> comments = commentDAO.findCommentsByRating(rating);
		
		mv.addObject("comments", comments);
		mv.setViewName("results");
		
		return mv;
	}
	
	// Finds active comments through restroom id
	@RequestMapping(path = "findActiveCommentsByRestroomIdComment.do", method = RequestMethod.GET)
	public ModelAndView findActiveCommentsByRestroomId(int id, Boolean active) {
		ModelAndView mv = new ModelAndView();
		
		List<Comment> comments = commentDAO.findCommentsByActiveByRestroom(id, active);
		
		mv.addObject("comments", comments);
		mv.setViewName("results");
		
		return mv;
	}
	
	// Find comments by date they were created
	@RequestMapping(path = "findCommentsByCreatedDateComment.do", method = RequestMethod.GET)
	public ModelAndView findCommentsByCreatedDate(Date date) {
		ModelAndView mv = new ModelAndView();
		
		List<Comment> comments = commentDAO.findCommentsByDateCreated(date);
		
		mv.addObject("comments", comments);
		mv.setViewName("results");
		return mv;
		
	}
	
	@RequestMapping(path="adminAddsAddressLocationRestroom.do")
	public ModelAndView addAddressLocationRestroom() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("newEntry", true);
		mv.setViewName("add");
		return mv;
	}
	
	@RequestMapping(path="adminAddsAddress.do", method = RequestMethod.POST)
	public ModelAndView userAddsAddress(Address address, HttpSession session) {
		
		session.setAttribute("newAddress", address);
		ModelAndView mv = new ModelAndView();
		mv.addObject("addLocationNext", true);
		mv.setViewName("add");
		return mv;
	}
	@RequestMapping(path="adminAddsLocation.do", method = RequestMethod.POST)
	public ModelAndView userAddsLocation(Location location, HttpSession session) {
		session.setAttribute("newLocation", location);
		ModelAndView mv = new ModelAndView();
		mv.addObject("addRestroomNext", true);
		mv.setViewName("add");
		return mv;
	}
	@RequestMapping(path="adminAddsRestroom.do", method = RequestMethod.POST)
	public ModelAndView userAddsRestroom(HttpSession session,int userId, Restroom restroom) {
		
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
		
	@RequestMapping(path="profileAdmin.do", method = RequestMethod.GET)
	public ModelAndView goToAdminProfile() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminProfile");
		return mv;
	}
	
	// Maps update location button in admin profile to be able to update a location through controller
	@RequestMapping(path="adminUpdateLocation.do", method = RequestMethod.GET)
	public ModelAndView goToUpdatePage(int id) {
		ModelAndView mv = new ModelAndView();
		Location updateLocation = locationDAO.getLocationById(id);
		mv.addObject("updateLocation", updateLocation);
		mv.setViewName("update");
		return mv;
	}
	
	// Admin Updates previous location
	@RequestMapping(path="adminUpdateLocationAdmin.do", method = RequestMethod.POST)
	public ModelAndView adminUpdateLocation(@ModelAttribute("location")Location location, 
			@RequestParam("locationId") int locationId, RedirectAttributes redir) {
		
		ModelAndView mv = new ModelAndView();
		Location locationToUpdate = locationDAO.getLocationById(locationId);
		int addressIdAttachedToThisLocation = locationToUpdate.getAddress().getId();
		System.out.println(addressIdAttachedToThisLocation);

		System.out.println("id= " + locationId);
//		System.out.println("Address= " + address);
		System.out.println("Location= " +location);
		System.out.println("Location to update= " +locationToUpdate);
		
		
		
		location.setOpenTime(locationToUpdate.getOpenTime());
		location.setCloseTime(locationToUpdate.getCloseTime());
		
//		location.setAddress(address);
		Location newUpdatedLocation = locationDAO.updateLocation(locationId, location);
		if(newUpdatedLocation != null) {
			redir.addFlashAttribute("updatedLocation", newUpdatedLocation);
			mv.setViewName("adminUpdatedLocationAdmin.do");
		}
		else {
			mv.setViewName("update");
		}
		
		return mv;
	}
	@RequestMapping(path="adminUpdatedLocationAdmin.do", method = RequestMethod.GET)
	public ModelAndView updatedLocation() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("update");
			
			return mv;
	}
	
	// Lists all locations
	@RequestMapping(path = "listAllLocations.do", method = RequestMethod.GET)
	public ModelAndView getAllLocations() {
		ModelAndView mv = new ModelAndView();
		
		List<Location> allLocations = locationDAO.getAllLocations();
		mv.addObject("allLocations", allLocations);
		mv.setViewName("results");
		
		return mv;
		
	}
		
		
		
		
		

}
