package es.kairosds.blogservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.kairosds.blogservice.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);

}
