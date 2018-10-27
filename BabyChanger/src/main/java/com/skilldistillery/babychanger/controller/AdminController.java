package com.skilldistillery.babychanger.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.skilldistillery.babychanger.entities.Comment;
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
	// Marks comment with flag (true/false) ************ check if correct
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
	@RequestMapping(path = "addComment.do", method = RequestMethod.POST)
	public ModelAndView addComment(Comment comment, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		
		Comment addcomment = commentDAO.addComment(comment);
		redir.addFlashAttribute("addComment", addcomment);
		mv.setViewName("redirect:addedComment");
		
		return mv;
		
	}
	@RequestMapping(path = "addedComment.do", method = RequestMethod.GET)
	public ModelAndView addedComment() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("confirmation");
		
		return mv;
		
	}
	// Edits a previous comment *****************check if this is correct
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

}
