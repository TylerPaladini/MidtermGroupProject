package com.skilldistillery.babychanger.data;

import java.util.Date;
import java.util.List;

import com.skilldistillery.babychanger.entities.Comment;
import com.skilldistillery.babychanger.entities.Rating;
import com.skilldistillery.babychanger.entities.Restroom;
import com.skilldistillery.babychanger.entities.Users;

public interface CommentDAO {

	Comment findCommentById(int id);
	List<Comment> findCommentsByUserId(int id);
	List<Comment> findCommentsByRestroomId(int id);
	List<Comment> findCommentsByComment(String comment);
	List<Comment> findCommentsByFlagComment(Boolean flag);
	List<Comment> findCommentsByRating(int rating);
	List<Comment> findCommentsByActiveByRestroom(int id, Boolean active);
	List<Comment> findCommentsByDateCreated(Date date);
	Comment addComment(Comment comment);
	Comment editComment(int id, Comment comment);
	boolean disableComment(int id);
	boolean enableComment(int id);
	boolean deleteComment(int id);
	boolean updateFlag(int id, boolean isFlag);
	
}
