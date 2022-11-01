package yeilux.com.proyecto.security.services;

import yeilux.com.proyecto.Class.usuario.usuario;
import yeilux.com.proyecto.security.Class.MainUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        usuario user = userService.getByUserName(email).get();
        return MainUser.build(user);
    }
    
}
