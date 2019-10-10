package es.kairosds.blogservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.kairosds.blogservice.exception.ComentarioOfensivoException;
import es.kairosds.blogservice.model.Comentario;
import es.kairosds.blogservice.model.Articulo;
import es.kairosds.blogservice.repository.ArticuloRepository;


@Service
public class ArticuloService {
	
	@Autowired
	ArticuloRepository articuloRepository;

	public Articulo crearPost(Articulo post) {
		return articuloRepository.save(post);
	}
	
	public List<Articulo> obtenerTodos(){
		return articuloRepository.findAll();
	}

	public Articulo comentarUnPost(Long id, Comentario comentario) throws ComentarioOfensivoException {
		Optional<Articulo> articulo = articuloRepository.findById(id);
		
		if (articulo.isPresent()) {
			
		} else {
			
		}
		
		return null;
	}
	
	private void chequearLenguajeOfensivo() throws ComentarioOfensivoException {
		
	}

}
