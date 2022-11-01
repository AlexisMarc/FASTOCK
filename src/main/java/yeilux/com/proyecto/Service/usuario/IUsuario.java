package yeilux.com.proyecto.Service.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yeilux.com.proyecto.Class.usuario.usuario;
@Repository
public interface IUsuario extends JpaRepository<usuario, Integer>{
    Optional<usuario> findByUserName(String email);
    boolean existsByUserName(String email);
}
