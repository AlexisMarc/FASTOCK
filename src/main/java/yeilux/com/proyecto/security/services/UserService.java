package yeilux.com.proyecto.security.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeilux.com.proyecto.Class.usuario.usuario;
import yeilux.com.proyecto.Service.usuario.IUsuario;

@Service
@Transactional
public class UserService {
    private final IUsuario userRepository;

    @Autowired
    public UserService(IUsuario userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<usuario> getByUserName(String email){
        return userRepository.findByUserName(email);
    }
    public boolean existByUserName(String email){
        return userRepository.existsByUserName(email);
    }
}
