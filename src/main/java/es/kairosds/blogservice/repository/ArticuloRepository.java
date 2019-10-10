package es.kairosds.blogservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.kairosds.blogservice.model.Articulo;

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {

}
