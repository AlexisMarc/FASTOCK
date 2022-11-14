package fastock.fastock.Service.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fastock.fastock.Class.usuario.privilegios;

@Repository
public interface IPrivilegios extends JpaRepository<privilegios, Integer>{

}
