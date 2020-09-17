package org.generation.blogPessoal.repository;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{ 
	public List<Usuario> findAllByNomeContainingIgnorCase(String nome);
	public  Optional<Usuario> findByUsuario(String usuario);
	public Optional<Usuario> findByUsuarioAndSenha(String usuario, String senha);
		
}


