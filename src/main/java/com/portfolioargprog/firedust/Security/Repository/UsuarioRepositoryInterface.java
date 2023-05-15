package com.portfolioargprog.firedust.Security.Repository;

import com.portfolioargprog.firedust.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositoryInterface extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByNombreUsuario(String NombreUsuario);
    
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
}
