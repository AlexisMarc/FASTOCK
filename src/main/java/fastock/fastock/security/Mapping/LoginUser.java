package fastock.fastock.security.Mapping;

import javax.validation.constraints.NotBlank;

public class LoginUser {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    public String getEmail() {
        return email;
    }
    public void setEmail(String Email) {
        this.email = Email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
