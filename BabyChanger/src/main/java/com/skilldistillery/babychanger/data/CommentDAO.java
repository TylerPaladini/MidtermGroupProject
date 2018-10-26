package com.skilldistillery.babychanger.data;

import java.util.Date;
import java.util.List;

import com.skilldistillery.babychanger.entities.Comment;
import com.skilldistillery.babychanger.entities.Rating;
import com.skilldistillery.babychanger.entities.Restroom;
import com.skilldistillery.babychanger.entities.Users;

public interface CommentDAO {

	Comment findCommentById(int id);
	List<Comment> findAll();
	List<Comment> findCommentsByUser(Users user);
	List<Comment> findCommentsByUserId(int id);
	List<Comment> findCommentsByRestroom(Restroom restroom);
	List<Comment> findCommentsByRestroomId(int id);
	List<Comment> findCommentsByKeywords(String keywords);
	List<Comment> findCommentsByComment(String comment);
	List<Comment> findCommentsByFlagComment(Boolean flag);
	List<Comment> findCommentsByRating(Rating rating);
	List<Comment> findCommentsByRating(int rating);
	List<Comment> findCommentsByActive(Boolean active);
	List<Comment> findCommentsByDateCreated(Date date);
	boolean addComment(Comment comment);
	boolean editComment(int id, Comment comment);
	boolean deleteComment(int id);
	
}
