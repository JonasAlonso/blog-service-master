package es.kairosds.blogservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.kairosds.blogservice.model.Comentario;
import es.kairosds.blogservice.repository.ComentarioRepository;

@Service
public class ComentarioService {
	
	@Autowired
	ComentarioRepository comentarioRepository;
	
	public Comentario comentar(Comentario comentario){
		return comentarioRepository.save(comentario);
	}

}
