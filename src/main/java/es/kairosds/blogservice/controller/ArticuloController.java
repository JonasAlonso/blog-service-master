package es.kairosds.blogservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.kairosds.blogservice.exception.ComentarioOfensivoException;
import es.kairosds.blogservice.model.Comentario;
import es.kairosds.blogservice.model.Post;
import es.kairosds.blogservice.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Post crearPost(@RequestBody Post post) {
		return postService.crearPost(post);
	}
	
	@GetMapping("/")
	public List<Post> obtenerTodosLosArticulos(){
		return postService.obtenerTodos();
	}
	
	@PostMapping("/{id}/comentario")
	@ResponseStatus(HttpStatus.CREATED)
	public Post comentarUnPost(@PathVariable Long id, @RequestBody Comentario comentario) throws ComentarioOfensivoException {
		return postService.comentarUnPost(id,comentario);
		
	}

}
