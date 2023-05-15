package com.portfolioargprog.firedust.Security.Service;

import com.portfolioargprog.firedust.Security.Entity.Rol;
import com.portfolioargprog.firedust.Security.Enums.RolNombre;
import com.portfolioargprog.firedust.Security.Repository.RolRepositoryInterface;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    RolRepositoryInterface RolRepositoryInterface;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return RolRepositoryInterface.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        RolRepositoryInterface.save(rol);
    }
}
