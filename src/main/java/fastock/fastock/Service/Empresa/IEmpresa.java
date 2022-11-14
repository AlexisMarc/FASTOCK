package fastock.fastock.Service.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fastock.fastock.Class.empresa.empresa;
@Repository
public interface IEmpresa extends JpaRepository<empresa, Integer>{
    
}
