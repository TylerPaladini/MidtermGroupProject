package com.skilldistillery.babychanger.data;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.skilldistillery.babychanger.entities.Comment;
import com.skilldistillery.babychanger.entities.Rating;
import com.skilldistillery.babychanger.entities.Restroom;
import com.skilldistillery.babychanger.entities.Users;

@Transactional
@Repository
public class CommentDAOImpl implements CommentDAO {
	
	private final String FIND_ALL = "SELECT c FROM Comment c";
	private final String FIND_BY_USER_ID = "SELECT c FROM Comment c WHERE c.user.id = :id";
	private final String FIND_BY_RESTROOM_ID = "SELECT c FROM Comment c WHERE c.restroom.id = :id";
	private final String FIND_BY_KEYWORDS = "";
	private final String FIND_BY_FLAG = "";
	private final String FIND_BY_RATING = "";
	private final String FIND_BY_ACTIVE = "";
	private final String FIND_BY_DATE = "";
	
	@PersistenceContext
	private EntityManager em;
	
	
	
	
	@Override
	public List<Comment> findAll() {
		return em.createQuery(FIND_ALL, Comment.class).getResultList();
	}

	@Override
	public Comment findCommentById(int id) {
		return em.find(Comment.class, id);
	}
	
	@Override
	public List<Comment> findCommentsByUserId(int id) {
		return em.createQuery(FIND_BY_USER_ID, Comment.class)
				.setParameter("id", id)
				.getResultList();
	}

	@Override
	public List<Comment> findCommentsByUser(Users user) {
		int id = user.getId();
		return findCommentsByUserId(id);
	}

	@Override
	public List<Comment> findCommentsByRestroomId(int id) {
		return em.createQuery(FIND_BY_RESTROOM_ID, Comment.class)
				.setParameter("id", id)
				.getResultList();
	}

	@Override
	public List<Comment> findCommentsByRestroom(Restroom restroom) {
		int id = restroom.getId();
		return findCommentsByRestroomId(id);
	}

	@Override
	public List<Comment> findCommentsByKeywords(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findCommentsByFlagComment(Boolean flag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findCommentsByRating(Rating rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findCommentsByRating(int rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findCommentsByActive(Boolean active) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findCommentsByDateCreated(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addComment(Comment comment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editComment(int id, Comment comment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteComment(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
