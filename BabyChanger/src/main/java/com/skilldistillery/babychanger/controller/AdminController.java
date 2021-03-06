package com.skilldistillery.babychanger.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
//	@RequestMapping(path = "createUserAdmin.do", method = RequestMethod.POST)
//	public ModelAndView createUserAdmin(Users newUser, RedirectAttributes redir) {
//		ModelAndView mv = new ModelAndView();
//		Users userCreated = usersDAO.createUsers(newUser);
//		redir.addFlashAttribute("user", userCreated);
//		mv.setViewName("redirect:createdUserAdmin.do");
//		return mv;
//	}

//	@RequestMapping(path = "createdUserAdmin.do", method = RequestMethod.GET)
//	public ModelAndView createdUserAdmin() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("profile");
//		return mv;
//	}

	/*
	 * Update user profile
	 */
	@RequestMapping(path = "updateProfilePageAdmin.do", method = RequestMethod.GET)
	public ModelAndView updateAdminPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("updatedUser", true);
		mv.setViewName("update");
		return mv;
	}

	@RequestMapping(path = "updateUserAdmin.do", method = RequestMethod.POST)
	public ModelAndView updateUserAdmin(Users updatedUser, int id, RedirectAttributes redir, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		updatedUser.setAdmin(true);
		Users userUpdated = usersDAO.updateUsers(id, updatedUser);
		if (userUpdated != null) {
			session.setAttribute("loggedIn", userUpdated);
			redir.addFlashAttribute("updateUserSuccess", true);
		} else {
			redir.addFlashAttribute("updateUserFailed", true);
		}
		mv.setViewName("redirect:updatedUserAdmin.do");
		return mv;
	}

	@RequestMapping(path = "updatedUserAdmin.do", method = RequestMethod.GET)
	public ModelAndView updatedUserAdmin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminProfile");
		mv.addObject("profileUpdateSuccess", true);
		return mv;
	}
	
	@RequestMapping(path = "userEditSearchPage.do", method = RequestMethod.POST)
	public ModelAndView searchUserToEditPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("adminPowerOnUser", true);
		mv.setViewName("search");
		return mv;
	}
	@RequestMapping(path = "locationEditSearchPage.do", method = RequestMethod.POST)
	public ModelAndView searchLocationToEditPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("adminPowerOnLocation", true);
		mv.setViewName("search");
		return mv;
	}
	
//	@RequestMapping(path = "updateLocationSearch.do", method = RequestMethod.POST)
//	public ModelAndView searchUpdateLocationPage() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("searchForUpdateLocation", true);
//		mv.setViewName("search");
//		return mv;
//	}
	
//	@RequestMapping(path = "deleteLocationSearch.do", method = RequestMethod.POST)
//	public ModelAndView searchDeleteLocationPage() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("searchForDeleteLocation", true);
//		mv.setViewName("search");
//		return mv;
//	}

	
	/*
	 * Disable user profile
	 */
	@RequestMapping(path = "disableUserAdmin.do", method = RequestMethod.POST)
	public ModelAndView disableUserAdmin(int userId, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		boolean disabledUser = usersDAO.disableUser(userId);
		redir.addFlashAttribute("disableUserSuccess", true);
		mv.setViewName("redirect:disabledUserAdmin.do");
		return mv;
	}

	@RequestMapping(path = "disabledUserAdmin.do", method = RequestMethod.GET)
	public ModelAndView disabledUserAdmin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminProfile");

		return mv;

	}
	/*
	 * Activate user profile
	 */
	@RequestMapping(path = "activateUserAdmin.do", method = RequestMethod.POST)
	public ModelAndView activateUserAdmin(int userId, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		boolean activateUser = usersDAO.activateUser(userId);
		redir.addFlashAttribute("activateUserSuccess", true);
		mv.setViewName("redirect:activatedUserAdmin.do");
		return mv;
	}
	
	@RequestMapping(path = "activatedUserAdmin.do", method = RequestMethod.GET)
	public ModelAndView activatedUserAdmin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminProfile");
		
		return mv;
		
	}
	/*
	 * Give admin privileges to user profile
	 */
	@RequestMapping(path = "giveAdminPowerToUserAdmin.do", method = RequestMethod.POST)
	public ModelAndView givePowerToUserAdmin(int userId, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		boolean gavePowerToUser = usersDAO.giveUserAdminPower(userId);
		redir.addFlashAttribute("gavePowerToUser", true);
		mv.setViewName("redirect:gavePowerToUserAdmin.do");
		return mv;
	}
	
	@RequestMapping(path = "gavePowerToUserAdmin.do", method = RequestMethod.GET)
	public ModelAndView gavePowerToUserAdmin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminProfile");
		
		return mv;
		
	}
	/*
	 * take admin privileges to user profile
	 */
	@RequestMapping(path = "takeAdminPowerFromUserAdmin.do", method = RequestMethod.POST)
	public ModelAndView takePowerFromUserAdmin(int userId, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		boolean takePowerFromUser = usersDAO.takeAdminPowerFromUser(userId);
		redir.addFlashAttribute("takePowerFromUser", true);
		mv.setViewName("redirect:takenPowerFromUserAdmin.do");
		return mv;
	}
	
	@RequestMapping(path = "takenPowerFromUserAdmin.do", method = RequestMethod.GET)
	public ModelAndView takenPowerUserAdmin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminProfile");
		
		return mv;
		
	}
	
	/*
	 * Delete user profile
	 */
	@RequestMapping(path = "deleteUserAdmin.do", method = RequestMethod.POST)
	public ModelAndView deleteUserAdmin(int userId, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		
		boolean deletedUser = usersDAO.deleteUsers(userId);
		redir.addFlashAttribute("deleteUserSuccess", true);
		mv.setViewName("redirect:deletedUserAdmin.do");
		
		return mv;
	}
	
	@RequestMapping(path = "deletedUserAdmin.do", method = RequestMethod.GET)
	public ModelAndView deletedUserAdmin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminProfile");
		
		return mv;
		
	}

	// comes here when admin has confirmed they are deleting
	// a profile completely from the Database and redirects
	// preventing refresh errors
//	@RequestMapping(path = "confirmDeleteAdmin.do", method = RequestMethod.POST)
//	public ModelAndView tryDeletingProfileFromDB(int userId, RedirectAttributes redir) {
//		ModelAndView mv = new ModelAndView();
//		boolean deleteSuccess = usersDAO.deleteUsers(userId);
//		redir.addFlashAttribute("deleteSuccess", deleteSuccess);
//		mv.setViewName("redirect:deleteCompleteAdmin.do");
//		return mv;
//	}

	// comes here when redirected from confirmDelete and confirms
	// to admin if delete was successful or not
//	@RequestMapping(path = "deleteCompleteAdmin.do", method = RequestMethod.GET)
//	public ModelAndView deleteProfileFromDBComplete() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("confirmation");
//		return mv;
//	}

//	@RequestMapping(path = "getAllUsersAdmin.do", method = RequestMethod.GET)
//	public ModelAndView getAllUsersAdmin() {
//		ModelAndView mv = new ModelAndView();
//		List<Users> allUsers = usersDAO.listAllUsers();
//		mv.addObject("allUsers", allUsers);
//		mv.setViewName("results");
//		return mv;
//	}

	/*
	 * Disables comments made by a user
	 */
	@RequestMapping(path = "disableCommentAdmin.do", method = RequestMethod.POST)
	public ModelAndView disableComment(int id, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		commentDAO.disableComment(id);
		int locationId = commentDAO.findCommentById(id).getRestroom().getLocation().getId();
		Double averageRating = locationDAO.getAverageRating(locationId);
		redir.addFlashAttribute("location", locationDAO.getLocationById(locationId));
		redir.addFlashAttribute("averageRating", averageRating);
		mv.setViewName("redirect:disabledCommentAdmin.do");
		return mv;
	}

	@RequestMapping(path = "disabledCommentAdmin.do", method = RequestMethod.GET)
	public ModelAndView disabledComment() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("disabledComment", true);
		mv.setViewName("detailedResults");
		return mv;

	}

	/*
	 * Enables comments by a user
	 */
//	@RequestMapping(path = "enableComment.do", method = RequestMethod.POST)
//	public ModelAndView enableComment(int id) {
//		ModelAndView mv = new ModelAndView();
//		commentDAO.enableComment(id);
//		mv.setViewName("redirect:enabledComment");
//		return mv;
//	}

//	@RequestMapping(path = "enabledComment.do", method = RequestMethod.GET)
//	public ModelAndView enabledComment() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("confirmation");
//
//		return mv;
//
//	}

	/*
	 * Permanently deletes comment by a user from the database
	 */
//	@RequestMapping(path = "deleteComment.do", method = RequestMethod.POST)
//	public ModelAndView deleteComment(int id) {
//		ModelAndView mv = new ModelAndView();
//		commentDAO.deleteComment(id);
//		mv.setViewName("redirect:deletedComment");
//		return mv;
//	}

//	@RequestMapping(path = "deletedComment.do", method = RequestMethod.GET)
//	public ModelAndView deletedComment() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("confirmation");
//
//		return mv;
//	}

	/*
	 * Marks comment with flag (true/false)
	 */
	@RequestMapping(path = "updateFlagCommentAdmin.do", method = RequestMethod.POST)
	public ModelAndView updateFlag(int id, boolean isFlag, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		commentDAO.updateFlag(id, isFlag);
		int locationId = commentDAO.findCommentById(id).getRestroom().getLocation().getId();
		Double averageRating = locationDAO.getAverageRating(locationId);
		redir.addFlashAttribute("location", locationDAO.getLocationById(locationId));
		redir.addFlashAttribute("averageRating", averageRating);
		mv.setViewName("redirect:updatedFlagCommentAdmin.do");
		return mv;
	}

	@RequestMapping(path = "updatedFlagCommentAdmin.do", method = RequestMethod.GET)
	public ModelAndView updatedFlag() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("detailedResults");
		mv.addObject("flaggedComment", true);
		return mv;
	}
	
	/*
	 * unflag flagged restrooms
	 */
	@RequestMapping(path = "unflagRestroom.do", method = RequestMethod.POST)
	public ModelAndView updateFlag(int restroomId, String unflaggedReason) {
		ModelAndView mv = new ModelAndView();
		boolean unflagSuccess = restroomDAO.updateFlag(restroomId, false, unflaggedReason);
		
		int locationId = restroomDAO.getRestroom(restroomId).getLocation().getId();
		Location location = locationDAO.getLocationById(locationId);
		Double averageRating = locationDAO.getAverageRating(locationId);
		mv.addObject("location",location);
		mv.addObject("averageRating", averageRating);
		mv.addObject("unflagSuccess", unflagSuccess);
		mv.setViewName("detailedResults");
		
		return mv;
	}
	
	/*
	 * unflag flagged comment
	 */
	@RequestMapping(path = "unflagComment.do", method = RequestMethod.POST)
	public ModelAndView updateFlag(int commentId) {
		ModelAndView mv = new ModelAndView();
		boolean unflagCommentSuccess = commentDAO.updateFlag(commentId, false);
		int locationId = commentDAO.findCommentById(commentId).getRestroom().getLocation().getId();
		Location location = locationDAO.getLocationById(locationId);
		Double averageRating = locationDAO.getAverageRating(locationId);
		mv.addObject("location",location);
		mv.addObject("averageRating",averageRating);
		mv.addObject("unflagCommentSuccess", unflagCommentSuccess);
		mv.setViewName("detailedResults");
		return mv;
	}

	/*
	 * Adds comment
	 */
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
		Comment addComment = commentDAO.addComment(comment);
		int locationId = addComment.getRestroom().getLocation().getId();
		Double averageRating = locationDAO.getAverageRating(locationId);
		redir.addFlashAttribute("location", locationDAO.getLocationById(locationId));
		redir.addFlashAttribute("averageRating", averageRating);
		mv.setViewName("redirect:addedCommentAdmin.do");
		return mv;
	}

	@RequestMapping(path = "addedCommentAdmin.do", method = RequestMethod.GET)
	public ModelAndView addedComment() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("commentAdded", true);
		mv.setViewName("detailedResults");

		return mv;

	}

	/*
	 * Edits a previous comment
	 */
//	@RequestMapping(path = "editComment.do", method = RequestMethod.POST)
//	public ModelAndView editComment(int id, Comment comment, RedirectAttributes redir) {
//		ModelAndView mv = new ModelAndView();
//		Comment editComment = commentDAO.editComment(id, comment);
//		redir.addFlashAttribute("editComment", editComment);
//		mv.setViewName("redirect:editedComment.do");
//		return mv;
//	}

//	@RequestMapping(path = "editedComment.do", method = RequestMethod.GET)
//	public ModelAndView editedComment() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("confirmtion");
//		return mv;
//	}

	/*
	 * Finds a comment with the comment ID
	 */
//	@RequestMapping(path = "findComment.do", method = RequestMethod.GET)
//	public ModelAndView findCommitById(int id) {
//		ModelAndView mv = new ModelAndView();
//		Comment comment = commentDAO.findCommentById(id);
//		mv.addObject("comment", comment);
//		mv.setViewName("results");
//		return mv;
//	}

	/*
	 * Finds a comment using the User ID
	 */
//	@RequestMapping(path = "findCommentsByUserIdComment.do", method = RequestMethod.GET)
//	public ModelAndView findCommentByUserId(int id) {
//		ModelAndView mv = new ModelAndView();
//		List<Comment> comments = commentDAO.findCommentsByUserId(id);
//		mv.addObject("comments", comments);
//		mv.setViewName("results");
//		return mv;
//	}

	/*
	 * \Finds a comment by Restroom iD
	 */
//	@RequestMapping(path = "findCommentsByRestroomIdComment.do", method = RequestMethod.GET)
//	public ModelAndView findCommentsByRestroomId(int id) {
//		ModelAndView mv = new ModelAndView();
//		List<Comment> comments = commentDAO.findCommentsByRestroomId(id);
//		mv.addObject("comments", comments);
//		mv.setViewName("results");
//		return mv;
//	}

	/*
	 * Finds comment by a comment (string)
	 */
//	@RequestMapping(path = "findCommentsByComments.do", method = RequestMethod.GET)
//	public ModelAndView findCommentsByComment(String comment) {
//		ModelAndView mv = new ModelAndView();
//		List<Comment> comments = commentDAO.findCommentsByComment(comment);
//		mv.addObject("comments", comments);
//		mv.setViewName("results");
//		return mv;
//	}

	/*
	 * Finds comments by Flagged comments
	 */
//	@RequestMapping(path = "findCommnetsByFlaggedComment.do", method = RequestMethod.GET)
//	public ModelAndView findCommentsByFlaggedComment(Boolean flag) {
//		ModelAndView mv = new ModelAndView();
//		List<Comment> comments = commentDAO.findCommentsByFlagComment(flag);
//		mv.addObject("comments", comments);
//		mv.setViewName("results");
//		return mv;
//	}

	/*
	 * Finds comments by their rating
	 */
//	@RequestMapping(path = "findCommentsByRatingComment.do", method = RequestMethod.GET)
//	public ModelAndView findCommentsByRating(int rating) {
//		ModelAndView mv = new ModelAndView();
//		List<Comment> comments = commentDAO.findCommentsByRating(rating);
//		mv.addObject("comments", comments);
//		mv.setViewName("results");
//		return mv;
//	}

	/*
	 * Finds active comments through restroom id
	 */
//	@RequestMapping(path = "findActiveCommentsByRestroomIdComment.do", method = RequestMethod.GET)
//	public ModelAndView findActiveCommentsByRestroomId(int id, Boolean active) {
//		ModelAndView mv = new ModelAndView();
//		List<Comment> comments = commentDAO.findCommentsByActiveByRestroom(id, active);
//		mv.addObject("comments", comments);
//		mv.setViewName("results");
//		return mv;
//	}

	/*
	 * Find comments by date they were created
	 */
//	@RequestMapping(path = "findCommentsByCreatedDateComment.do", method = RequestMethod.GET)
//	public ModelAndView findCommentsByCreatedDate(Date date) {
//		ModelAndView mv = new ModelAndView();
//		List<Comment> comments = commentDAO.findCommentsByDateCreated(date);
//		mv.addObject("comments", comments);
//		mv.setViewName("results");
//		return mv;
//	}

	/*
	 * add new location with address and restroom
	 */
	@RequestMapping(path = "adminAddsAddressLocationRestroom.do")
	public ModelAndView addAddressLocationRestroom() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("createAddressModel", new Address());
		mv.addObject("newEntry", true);
		mv.setViewName("add");
		return mv;
	}

	// continued
	@RequestMapping(path = "adminAddsAddress.do", method = RequestMethod.POST)
	public ModelAndView adminAddsAddress(@Valid @ModelAttribute("createAddressModel") Address address, Errors errors,
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (errors.getErrorCount() != 0) {
			mv.setViewName("add");
			mv.addObject("newEntry", true);
		} else {
			session.setAttribute("newAddress", address);
			mv.addObject("createLocationModel", new Location());
			mv.addObject("addLocationNext", true);
			mv.setViewName("add");
		}
		return mv;
	}

	// continued
	@RequestMapping(path = "adminAddsLocation.do", method = RequestMethod.POST)
	public ModelAndView adminAddsLocation(@Valid @ModelAttribute("createLocationModel") Location location, Errors errors,
			HttpSession session) {
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

	// continued
	@RequestMapping(path = "adminAddsRestroom.do", method = RequestMethod.POST)
	public ModelAndView adminAddsRestroom(@Valid @ModelAttribute("createRestroomModel") Restroom restroom, Errors errors,
			HttpSession session, int userId) {
		ModelAndView mv = new ModelAndView();
		if (errors.getErrorCount() != 0) {
			mv.setViewName("add");
			mv.addObject("addLocationFailed", true);
			mv.addObject("newEntry", true);
		} else {
			// grab address and location from session
			Address newAddress = (Address) session.getAttribute("newAddress");
			Location newLocation = (Location) session.getAttribute("newLocation");
			
			// set newAddress in newLocation
			newLocation.setAddress(newAddress);
			
			// persist location
			Location addedLocation = locationDAO.createLocation(newLocation);
			
			// add restroom to persisted location and set userId of who created the restroom
			addedLocation.addRestroom(restroom);
			restroom.setUserId(userId);
			
			// persist restroom
			Restroom addedRestroom = restroomDAO.createRestroom(restroom);
			
			// ensure all successful and send to detailedResults
			boolean addSuccess = addedRestroom != null && addedLocation != null && newAddress != null;
			
			Double averageRating = locationDAO.getAverageRating(addedLocation.getId());
			
			mv.addObject("location", addedLocation);
			mv.addObject("averageRating", averageRating);
			mv.addObject("addLocationSuccess", addSuccess);
			mv.setViewName("detailedResults");
		}
		return mv;
	}

	@RequestMapping(path = "profileAdmin.do", method = RequestMethod.GET)
	public ModelAndView goToAdminProfile() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminProfile");
		return mv;
	}

	
	/*
	 * Maps update location button in admin profile to be able to update a location
	 * through controller
	 */
	@RequestMapping(path = "adminUpdateLocation.do", method = RequestMethod.GET)
	public ModelAndView goToUpdatePage(int id) {
		ModelAndView mv = new ModelAndView();
		Location updateLocation = locationDAO.getLocationById(id);
		mv.addObject("updateLocation", updateLocation);
		mv.addObject("adminUpdateLocationModel", new Location());
		mv.addObject("adminUpdatingLocation", true);
		mv.setViewName("update");
		return mv;
	}

	/*
	 * update a location
	 */
	@RequestMapping(path = "adminUpdateLocationAdmin.do", method = RequestMethod.POST)
	public ModelAndView adminUpdateLocation(@Valid @ModelAttribute("adminUpdateLocationModel") Location location,
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
			mv.addObject("adminUpdateAddressModel", new Address());
			mv.addObject("adminUpdateAddressNext", true);
			mv.setViewName("update");
		}
		return mv;
	}

	// continued
	@RequestMapping(path = "adminUpdateAddressAdmin.do", method = RequestMethod.POST)
	public ModelAndView adminUpdateAddress(@Valid @ModelAttribute("adminUpdateAddressModel") Address address,
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
			Double averageRating = locationDAO.getAverageRating(updatedLocation.getId());
			mv.addObject("locationUpdateSuccess", true);
			mv.addObject("location", locationUpdate);
			mv.addObject("averageRating", averageRating);
			mv.setViewName("detailedResults");
		}
		return mv;
	}

	/*
	 * user updates comment
	 */
	@RequestMapping(path = "updateCommentPageAdmin.do", method = RequestMethod.GET)
	public ModelAndView goToUpdateCommentPage(int commentId, HttpSession session) {
		Comment updatedComment = commentDAO.findCommentById(commentId);
		session.setAttribute("updatedComment", updatedComment);
		ModelAndView mv = new ModelAndView();
		mv.addObject("updatingComment", true);
		mv.setViewName("update");
		return mv;
	}

	
	@RequestMapping(path = "updateCommentAdmin.do", method = RequestMethod.POST)
	public ModelAndView updateComment(Comment comment, RedirectAttributes redir, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		int commentId = ((Comment) session.getAttribute("updatedComment")).getId();
		comment.setDateCreated(new Date());
		Comment newUpdatedComment = commentDAO.editComment(commentId, comment);
		int locationId = newUpdatedComment.getRestroom().getLocation().getId();
		Double averageRating = locationDAO.getAverageRating(locationId);
		redir.addFlashAttribute("location",  locationDAO.getLocationById(locationId));
		redir.addFlashAttribute("averageRating", averageRating);
		mv.setViewName("redirect:updatedCommentAdmin.do");
		return mv;
	}

	@RequestMapping(path = "updatedCommentAdmin.do", method = RequestMethod.GET)
	public ModelAndView updatedComment() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("updateComment", true);
		mv.setViewName("detailedResults");
		return mv;
	}

	/*
	 * Lists all restrooms that have been flagged
	 */
	@RequestMapping(path= "listAllFlaggedRestrooms.do", method= RequestMethod.GET)
	public ModelAndView getAllFlaggedRestrooms() {
		ModelAndView mv = new ModelAndView();
		List<Restroom> allFlaggedRestrooms = restroomDAO.getRestroomsByFlag(true);
		if(allFlaggedRestrooms != null && allFlaggedRestrooms.size()!=0 ) {
		mv.addObject("flaggedRestrooms", allFlaggedRestrooms);
		mv.setViewName("results");
		}
		else {
			mv.addObject("noFlaggedRestrooms", true);
			mv.addObject("allLocations", locationDAO.getAllLocations());
			mv.setViewName("results");
		}
		return mv;
	}
	
	/*
	 * Lists all comments that have been flagged
	 */
	@RequestMapping(path= "listAllFlaggedComments.do", method= RequestMethod.GET)
	public ModelAndView getAllFlaggedComments() {
		ModelAndView mv = new ModelAndView();
		List<Comment> allFlaggedComments = commentDAO.findCommentsByFlagComment(true);
		if(allFlaggedComments != null && allFlaggedComments.size()!=0 ) {
			mv.addObject("flaggedComments", allFlaggedComments);
			mv.setViewName("results");
		}
		else {
			mv.addObject("noFlaggedComments", true);
			mv.addObject("allLocations", locationDAO.getAllLocations());
			mv.setViewName("results");
		}
		return mv;
	}

	/*
	 * Maps user to update.jsp to update a location
	 */
	@RequestMapping(path = "adminUpdateRestroom.do", method = RequestMethod.GET)
	public ModelAndView goToUpdateRestroom(@RequestParam("restroomId") int restroomId, 
			@RequestParam("locationId") int locationId, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Restroom updateRestroom = restroomDAO.getRestroom(restroomId);
		session.setAttribute("locationId", locationId);
		mv.addObject("updateRestroom", updateRestroom);
		mv.addObject("adminUpdateRestroomModel", new Restroom());
		mv.addObject("adminUpdatingRestroom", true);
		mv.setViewName("update");
		return mv;
	}
	
	@RequestMapping(path="adminUpdateRestroomAdmin.do", method = RequestMethod.POST)
	public ModelAndView adminUpdateRestroom(@Valid @ModelAttribute("adminUpdateRestroomModel") Restroom restroom,
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
			mv.addObject("updateRestroomSuccess", true);
			mv.setViewName("detailedResults");
		}
		return mv;
	}
	
	@RequestMapping(path="deleteConfirmation.do")
	public ModelAndView adminDeleteLocationConfirm(int id) {
		ModelAndView mv = new ModelAndView();
		Location locationToDelete = locationDAO.getLocationById(id);
		mv.addObject("locationToDelete", locationToDelete);
		mv.setViewName("confirmation");
		return mv;
	}
	
	@RequestMapping(path="deleteLocation.do")
	public ModelAndView adminDeleteLocation (int id) {
		ModelAndView mv = new ModelAndView();
		boolean deletedLocation = locationDAO.deleteLocation(id);
		if(deletedLocation) {
			mv.addObject("locationDeletedSuccess", true);
			mv.setViewName("adminProfile");
		}
		else {
			Location locationAttemptedToDelete = locationDAO.getLocationById(id);
			Double averageRating = locationDAO.getAverageRating(locationAttemptedToDelete.getId());
			mv.addObject("location", locationAttemptedToDelete);
			mv.addObject("averageRating", averageRating);
			mv.addObject("locationNotDeleted", deletedLocation);
			mv.setViewName("detailedResults");
		}
		return mv;
	}
	
	@RequestMapping(path="disableLocation.do")
	public ModelAndView adminDisableLocation(int id) {
		ModelAndView mv = new ModelAndView();
		Location locationById = locationDAO.getLocationById(id);
		locationById.setAccessLimits("This location no longer available");
		Double averageRating = locationDAO.getAverageRating(locationById.getId());
		mv.addObject("location", locationById);
		mv.addObject("averageRating", averageRating);
		mv.addObject("locationDisabled", true);
		mv.setViewName("detailedResults");
		return mv;
	}
}
