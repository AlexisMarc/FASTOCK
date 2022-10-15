package yeilux.com.proyecto.Model.Interface.producto;

import org.springframework.data.jpa.repository.JpaRepository;

import yeilux.com.proyecto.Model.Class.producto.categoria;

import org.springframework.stereotype.Repository;
@Repository
public interface ICategoria extends JpaRepository<categoria, Integer> {
    
}
