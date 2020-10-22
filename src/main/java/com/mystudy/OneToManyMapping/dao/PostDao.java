package com.mystudy.OneToManyMapping.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mystudy.OneToManyMapping.model.Post;
import com.mystudy.repository.PostRepository;

/**
 * @author Keshav
 *
 */
@Repository
public class PostDao {
	@Autowired
	PostRepository postRepository;
	@PersistenceContext
	EntityManager entityManager;
	
	public Post save(Post post) {
		return postRepository.save(post);
	}

	@Transactional
	public Post find(long postId) {
		Optional<Post> optional = postRepository.findById(postId);
		if(optional.isPresent()) {
			optional.get().getComments().size();
			return optional.get();
		}
		return null;	
	}
	
	/*public Post find(long postId) {
		Post post = entityManager.createQuery("select p from Post p join fetch Comment c on p.postId = c.post.postId where p.postId = :postId", Post.class)
		.setParameter("postId", postId)
		.getSingleResult();
		Optional<Post> optional = postRepository.findById(postId);
		if(optional.isPresent()) {
			optional.get().setComments(null);
			return optional.get();
		}
		return post;	
	}*/
}
