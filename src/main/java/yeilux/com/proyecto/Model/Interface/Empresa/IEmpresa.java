package yeilux.com.proyecto.Model.Interface.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;

import yeilux.com.proyecto.Model.Class.empresa.empresa;
import org.springframework.stereotype.Repository;
@Repository
public interface IEmpresa extends JpaRepository<empresa, Integer>{
    
}
