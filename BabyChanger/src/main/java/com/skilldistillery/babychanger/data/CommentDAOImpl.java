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
	private final String FIND_BY_COMMENT = "SELECT c FROM Comment c WHERE c.comment like :comment";
	private final String FIND_BY_FLAG = "SELECT c FROM Comment c WHERE c.flagComment = :flag";
	private final String FIND_BY_RATING = "SELECT c FROM Comment c WHERE c.rating = :rating";
	private final String FIND_BY_ACTIVE = "SELECT c FROM Comment c WHERE c.active = :active";
	private final String FIND_BY_DATE = "SELECT c FROM Comment c WHERE c.dateCreated = :date";

	@PersistenceContext
	private EntityManager em;



	@Override
	public Comment findCommentById(int id) {
		return em.find(Comment.class, id);
	}

	@Override
	public List<Comment> findCommentsByUserId(int id) {
		return em.createQuery(FIND_BY_USER_ID, Comment.class).setParameter("id", id).getResultList();
	}

	

	@Override
	public List<Comment> findCommentsByRestroomId(int id) {
		return em.createQuery(FIND_BY_RESTROOM_ID, Comment.class).setParameter("id", id).getResultList();
	}





	@Override
	public List<Comment> findCommentsByComment(String comment) {
		return em.createQuery(FIND_BY_COMMENT, Comment.class).setParameter("comment","%" + comment + "%").getResultList();
	}

	@Override
	public List<Comment> findCommentsByFlagComment(Boolean flag) {
		return em.createQuery(FIND_BY_FLAG, Comment.class).setParameter("flag", flag).getResultList();
	}



	@Override
	public List<Comment> findCommentsByRating(int rating) {
		return em.createQuery(FIND_BY_RATING, Comment.class).setParameter("rating", rating).getResultList();
	}

	@Override
	public List<Comment> findCommentsByActiveByRestroom( int id, Boolean active) {
		return em.createQuery(FIND_BY_ACTIVE, Comment.class).setParameter("active", active).getResultList();
	}

	@Override
	public List<Comment> findCommentsByDateCreated(Date date) {
		return em.createQuery(FIND_BY_DATE, Comment.class).setParameter("date", date).getResultList();

	}

	@Override
	public Comment addComment(Comment comment, Restroom restroom) {
		Boolean active = true;
		comment.setActive(active);
		comment.setFlagComment(false);
		comment.getUser().addComment(comment);
//		comment.setRestroom(restroom);
		System.out.println(comment);
		em.persist(comment);
		em.flush();
		if (comment.getId() == 0) {
			em.getTransaction().rollback();
			return null;
		} else {
			return em.find(Comment.class, comment.getId());
		}
	}

	@Override
	public Comment editComment(int id, Comment comment) {
		Comment managed = em.find(Comment.class, id);

		if (managed != null) {
//			managed.setUser(comment.getUser());
			managed.setComment(comment.getComment());
			managed.setRating(comment.getRating().getValue());
		}
		return managed;
	}

	@Override
	public boolean disableComment(int id) {
		Comment managed = em.find(Comment.class, id);

		if (managed != null && managed.getActive()) {
			managed.setActive(false);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean enableComment(int id) {
		Comment managed = em.find(Comment.class, id);

		if (managed != null && !managed.getActive()) {
			managed.setActive(true);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteComment(int id) {
		Comment deleteComment = em.find(Comment.class, id);
		em.remove(deleteComment);
		if (em.find(Comment.class, id) != null) {
			em.getTransaction().rollback();
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean updateFlag(int id, boolean isFlag) {
		Comment managed = em.find(Comment.class, id);

		if (managed != null) {
			managed.setFlagComment(isFlag);
			return true;
		} else {
			return false;
		}
	}

}
