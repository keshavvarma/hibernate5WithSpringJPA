package com.mystudy.OneToManyMapping.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mystudy.OneToManyMapping.model.Comment;
import com.mystudy.OneToManyMapping.model.Post;
import com.mystudy.repository.CommentRepository;
import com.mystudy.repository.PostRepository;

/**
 * @author Keshav
 *
 */
@Repository
public class CommentDao {
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	PostRepository postRepository;
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public Comment save(Comment comment) throws Exception {
		//Post post = entityManager.find(Post.class, comment.getPost().getPostId());
		//Post post = entityManager.getReference(Post.class, comment.getPost().getPostId());
		Post post = postRepository.getOne(comment.getPost().getPostId());
		comment.setPost(post);
		return commentRepository.save(comment);
	}

	@Transactional
	public List<Comment> saveAll(List<Comment> comments, long postId) {
		final Post post = entityManager.find(Post.class, postId);
		comments.forEach(c -> {
			c.setPost(post);
		});
		return commentRepository.saveAll(comments);		
	}

	public List<Comment> findByPostId(long postId) {
		List<Comment> comments = entityManager.createQuery("SELECT c FROM Comment c WHERE c.post.postId = :postId ORDER BY c.commentId ASC", Comment.class)
				.setParameter("postId", postId)
				.getResultList();
		return comments;
	}
	
	public List<Comment> findCommetsByPostId(long postId) {
		List<Comment> comments = entityManager.createQuery("SELECT c FROM Comment c JOIN FETCH c.post p WHERE p.postId = :postId ORDER BY c.commentId ASC", Comment.class)
				.setParameter("postId", postId)
				.getResultList();
		return comments;
	}

	public Comment findById(long commentId) {
		Comment comment = entityManager.createQuery("SELECT c FROM Comment c WHERE c.commentId = :commentId", Comment.class)
		.setParameter("commentId", commentId)
		.getSingleResult();
		/*Optional<Comment> optional= commentRepository.findById(commentId);
		if(optional.isPresent()) {
			return optional.get();
		}*/
		return comment;
	}
}
