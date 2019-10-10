package es.kairosds.blogservice.controller;

import java.util.List;

import javax.annotation.PostConstruct;

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
import es.kairosds.blogservice.model.Articulo;
import es.kairosds.blogservice.model.Comentario;
import es.kairosds.blogservice.service.ComentarioService;
import es.kairosds.blogservice.service.ArticuloService;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {
	
	@Autowired
	ArticuloService postService;
	
	@Autowired
	ComentarioService comentarioService;
	
	@PostConstruct
	public void init() {
		
		Articulo post1 = new Articulo();
		
		post1.setAutor("Autor1");
		post1.setContenido("Contenido 1");
		
		Articulo post2 = new Articulo();
		
		post2.setAutor("Autor2");
		post2.setContenido("Contenido 2");
		
		postService.crearPost(post1);
		postService.crearPost(post2);
		
		Comentario comment = new Comentario();
		
		comment.setComentarista("troll 1 ");
		comment.setContenido("Contenido 2");
		comment.setArticulo(post1);
	
		comentarioService.comentar(comment);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Articulo crearPost(@RequestBody Articulo articulo) {
		return postService.crearPost(articulo);
	}
	
	@GetMapping("/")
	public List<Articulo> obtenerTodosLosArticulos(){
		return postService.obtenerTodos();
	}
	
	@PostMapping("/{id}/comentario")
	@ResponseStatus(HttpStatus.CREATED)
	public Articulo comentarUnPost(@PathVariable Long id, @RequestBody Comentario comentario) throws ComentarioOfensivoException {
		return postService.comentarUnPost(id,comentario);
		
	}

}
