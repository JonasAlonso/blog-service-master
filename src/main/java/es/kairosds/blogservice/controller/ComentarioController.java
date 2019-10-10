package es.kairosds.blogservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.kairosds.blogservice.model.Comentario;
import es.kairosds.blogservice.service.ComentarioService;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
	
	@Autowired
	ComentarioService comentarioService;
	
	@PostMapping("/")
	public ResponseEntity<Comentario> comentarPost(@RequestBody Comentario comentario){
		comentarioService.comentar(comentario);
		return null;
		
	}

}
