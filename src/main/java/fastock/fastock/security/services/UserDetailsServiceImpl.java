package fastock.fastock.security.services;

import fastock.fastock.Class.usuario.cargo;
import fastock.fastock.Class.usuario.privilegios;
import fastock.fastock.Class.usuario.usuario;
import fastock.fastock.Service.usuario.IUsuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IUsuario iUsuario;

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {

        Optional<usuario> user = iUsuario.findByUserName(userName);

        return new org.springframework.security.core.userdetails.User(
                user.get().getUserName(), user.get().getPassword(), user.get().getEstado(), true, true,
                true, getAuthorities(user.get().getCargo()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<cargo> roles) {

        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(Collection<cargo> roles) {

        List<String> privileges = new ArrayList<>();
        List<privilegios> collection = new ArrayList<>();
        for (cargo role : roles) {
            privileges.add(role.getCargo());
            collection.addAll(role.getPrivilegio());
        }
        for (privilegios item : collection) {
            privileges.add(item.getPrivilegio().name());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
