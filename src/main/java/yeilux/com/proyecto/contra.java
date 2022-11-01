package yeilux.com.proyecto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class contra {
    public static void main(String[] args) {
        PasswordEncoder password = new BCryptPasswordEncoder();
        System.out.println("La contraseña es:");
        System.out.println(password.encode("hola"));
    }
}
