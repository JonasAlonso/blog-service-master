package es.kairosds.blogservice.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.kairosds.blogservice.exception.ComentarioOfensivoException;
import es.kairosds.blogservice.model.Comentario;
import es.kairosds.blogservice.model.RespuestaAnalisis;
import es.kairosds.blogservice.model.Texto;
import es.kairosds.blogservice.model.Articulo;
import es.kairosds.blogservice.repository.ArticuloRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArticuloService {

	@Autowired
	ArticuloRepository articuloRepository;

	@Autowired
	AnalizadorDeLenguajeService analizadorDeLenguajeService;

	@Autowired
	ComentarioService comentarioService;

	public Articulo crearPost(Articulo post) {
		return articuloRepository.save(post);
	}

	public List<Articulo> obtenerTodos() {
		return articuloRepository.findAll();
	}

	public Articulo comentarUnPost(Long id, Comentario comentario) throws ComentarioOfensivoException {
		log.info("Buscando articulo con id: {}", id);
		Optional<Articulo> articulo = articuloRepository.findById(id);

		log.info("Llamando al servicio para analizar si el comentario contiene lenguaje ofensivo...");		
		chequearLenguajeOfensivo(analizadorDeLenguajeService.analizarComentario(Texto.builder().contenido(comentario.getContenido()).build()));

		if (articulo.isPresent()) {
			comentario.setArticulo(articulo.get());
			comentarioService.comentar(comentario);
			return articuloRepository.save(articulo.get());
		} else {
			log.error("Arcuticulo con id {} no encontrado.", id);
			throw new EntityNotFoundException();
		}
	}

	private void chequearLenguajeOfensivo(ResponseEntity<RespuestaAnalisis> r) throws ComentarioOfensivoException {
		if (r.getBody().getLenguajeOfensivo().size() > 0){
			throw new ComentarioOfensivoException();
		}
	}

	public Optional<Articulo> obtenerArticuloPorId(Long id) {
		return articuloRepository.findById(id);
	}

}
