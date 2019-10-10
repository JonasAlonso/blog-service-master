package es.kairosds.blogservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.kairosds.blogservice.model.Autor;
import es.kairosds.blogservice.repository.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	AutorRepository autorRepository;
	
	public Autor guardarAutor(Autor autor) {
		return autorRepository.save(autor);
	}

}
