package fastock.fastock.Service.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fastock.fastock.Class.usuario.cargo;
@Repository
public interface ICargo extends JpaRepository<cargo, Integer>{
}
