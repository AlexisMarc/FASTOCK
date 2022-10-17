package yeilux.com.proyecto.Model.Interface.empleado;


import org.springframework.data.jpa.repository.JpaRepository;

import yeilux.com.proyecto.Model.Class.empleado.admin;

import org.springframework.stereotype.Repository;
@Repository
public interface IAdmin extends JpaRepository<admin, Integer>{

}
