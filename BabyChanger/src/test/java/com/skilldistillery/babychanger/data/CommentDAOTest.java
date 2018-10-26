package com.skilldistillery.babychanger.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.babychanger.entities.Comment;

class CommentDAOTest {
	
	private CommentDAO dao;
	
	@BeforeEach
	void setUp() throws Exception {
		dao = new CommentDAOImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		dao = null;
	}
	
	@Test
	void test_find_all() {
		List<Comment> actual = dao.findAll();
		assertEquals(2, actual.size());
//		assertEquals("test comment", actual.get(0).getComment());
	}
	
	@Test
	void test_find_comment_by_id() {
		assertEquals("test comment", dao.findCommentById(1).getComment());
		assertEquals(1, dao.findCommentById(1).getRating());
		assertEquals(1, dao.findCommentById(1).getRestroom().getId());
	}

}
