/**
 * 
 */
package com.mystudy.OneToManyMapping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudy.OneToManyMapping.dao.CommentDao;
import com.mystudy.OneToManyMapping.model.Comment;

/**
 * @author om
 *
 */
@Service
public class CommentService {
	@Autowired
	CommentDao commentDao;
	
	public Comment save(Comment comment) throws Exception {
		return commentDao.save(comment);
	}

	public Comment find(long commentId) {
		return commentDao.findById(commentId);
	}

	public List<Comment> saveAll(List<Comment> comments, long postId) {
		return commentDao.saveAll(comments, postId);
	}

	public List<Comment> findCommentsByPostId(long postId) {
		return commentDao.findCommetsByPostId(postId);
	}

}
