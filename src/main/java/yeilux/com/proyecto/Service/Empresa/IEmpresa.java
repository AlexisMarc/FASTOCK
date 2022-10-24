package yeilux.com.proyecto.Service.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yeilux.com.proyecto.Class.empresa.empresa;
@Repository
public interface IEmpresa extends JpaRepository<empresa, Integer>{
    
}
