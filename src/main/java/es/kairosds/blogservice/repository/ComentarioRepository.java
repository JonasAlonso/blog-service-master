package es.kairosds.blogservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.kairosds.blogservice.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
