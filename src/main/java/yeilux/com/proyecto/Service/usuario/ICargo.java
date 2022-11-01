package yeilux.com.proyecto.Service.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yeilux.com.proyecto.Class.usuario.cargo;
@Repository
public interface ICargo extends JpaRepository<cargo, Integer>{
    Optional<ICargo> findByRoleName(String roleName);
}
