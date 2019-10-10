package es.kairosds.blogservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.kairosds.blogservice.model.Autor;
import es.kairosds.blogservice.service.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	AutorService autorService;

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Autor postAutor(@RequestBody Autor autor){
		return  autorService.guardarAutor(autor);
	}
	
}
