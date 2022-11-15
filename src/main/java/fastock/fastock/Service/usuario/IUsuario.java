package fastock.fastock.Service.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fastock.fastock.Class.usuario.usuario;
@Repository
public interface IUsuario extends JpaRepository<usuario, Integer>{
    Optional<usuario> findByUserName(String UserName);
}
