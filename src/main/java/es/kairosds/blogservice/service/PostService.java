package es.kairosds.blogservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.kairosds.blogservice.model.Post;
import es.kairosds.blogservice.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;

	public Post crearPost(Post post) {
		return postRepository.save(post);
	}

}
