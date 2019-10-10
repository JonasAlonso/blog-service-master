package es.kairosds.blogservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.kairosds.blogservice.model.Usuario;
import es.kairosds.blogservice.repository.UsuarioRepository;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	// private BCryptPasswordEncoder bCryptPasswordEncoder;

	public long insertarUsuario(Usuario usuario) {
		// usuario.setPswd(bCryptPasswordEncoder.encode(appUser.getPassword()));
		return usuarioRepository.save(usuario).getIdUsuario();
	}
	
    public void borrarUsuario(long id) {
    	usuarioRepository.deleteById(id);
    }

}
