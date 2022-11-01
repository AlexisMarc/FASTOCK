package yeilux.com.proyecto.security.services;

import java.util.Optional;

import javax.transaction.Transactional;

import yeilux.com.proyecto.Service.usuario.ICargo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService {

    private final ICargo roleRepository;

    @Autowired
    public RoleService(ICargo roleRepository) {
        this.roleRepository = roleRepository;
    }
    public Optional<ICargo> getByRoleName(String roleName){
        return roleRepository.findByRoleName(roleName);
    }
}
