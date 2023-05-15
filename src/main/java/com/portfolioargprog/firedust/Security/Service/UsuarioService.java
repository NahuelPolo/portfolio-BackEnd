package com.portfolioargprog.firedust.Security.Service;

import com.portfolioargprog.firedust.Security.Entity.Usuario;
import com.portfolioargprog.firedust.Security.Repository.UsuarioRepositoryInterface;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    UsuarioRepositoryInterface usuarioRepositoryInterface;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepositoryInterface.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepositoryInterface.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return usuarioRepositoryInterface.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        usuarioRepositoryInterface.save(usuario);
    }
}
