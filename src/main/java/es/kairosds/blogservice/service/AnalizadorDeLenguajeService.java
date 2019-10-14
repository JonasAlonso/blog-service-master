package es.kairosds.blogservice.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.kairosds.blogservice.model.Texto;

@FeignClient(name = "analizador-de-texto", url = "${analizador.microservicio.url}")
public interface AnalizadorDeLenguajeService {
	
	@RequestMapping( method = RequestMethod.POST, value = "/analizador/")
	List<String> analizarComentario(@RequestBody Texto texto);

	
}
