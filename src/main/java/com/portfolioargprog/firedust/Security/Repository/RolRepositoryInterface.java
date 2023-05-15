package com.portfolioargprog.firedust.Security.Repository;

import com.portfolioargprog.firedust.Security.Entity.Rol;
import com.portfolioargprog.firedust.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositoryInterface extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
