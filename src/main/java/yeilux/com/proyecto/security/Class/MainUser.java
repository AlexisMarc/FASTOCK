package yeilux.com.proyecto.security.Class;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import yeilux.com.proyecto.Class.usuario.usuario;

public class MainUser implements UserDetails {
    private String userName;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;


    public MainUser(String userName, String email, String password,
            Collection<? extends GrantedAuthority> authorities) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static MainUser build(usuario user){
        List<GrantedAuthority> authorities = user.getCargo().stream().map(role-> new SimpleGrantedAuthority(role.getroleName())).collect(Collectors.toList());
        return new MainUser(user.getUserName(), user.getEmail(), user.getPassword(), authorities);
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public String getEmail() {
        return email;
    }
    
}
