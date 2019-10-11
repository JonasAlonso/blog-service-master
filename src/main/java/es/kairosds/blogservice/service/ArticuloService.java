package es.kairosds.blogservice.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.kairosds.blogservice.exception.ComentarioOfensivoException;
import es.kairosds.blogservice.model.Comentario;
import es.kairosds.blogservice.model.Texto;
import es.kairosds.blogservice.model.Articulo;
import es.kairosds.blogservice.repository.ArticuloRepository;

@Service
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
		Optional<Articulo> articulo = articuloRepository.findById(id);
		Texto text = new Texto();
		text.setContenido(comentario.getContenido());

		//chequearLenguajeOfensivo(analizadorDeLenguajeService.analizarComentario(text));

		if (articulo.isPresent()) {
			comentario.setArticulo(articulo.get());
			comentarioService.comentar(comentario);
			return articuloRepository.save(articulo.get());
		} else {
			throw new EntityNotFoundException();
		}
	}

	private void chequearLenguajeOfensivo(List<String> palabrotas) throws ComentarioOfensivoException {
		if (palabrotas.size() > 0) {
			throw new ComentarioOfensivoException();
		}
	}

	public Optional<Articulo> obtenerArticuloPorId(Long id) {
		return articuloRepository.findById(id);
	}

}
