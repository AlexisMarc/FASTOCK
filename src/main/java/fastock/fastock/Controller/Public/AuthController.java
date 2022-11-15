package fastock.fastock.Controller.Public;

import javax.validation.Valid;

import fastock.fastock.Messages.MenssageScurity;
import fastock.fastock.security.Mapping.JwtDto;
import fastock.fastock.security.Mapping.LoginUser;
import fastock.fastock.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtProvider jwtProvider;
    
    @Autowired
    public AuthController(AuthenticationManagerBuilder authenticationManagerBuilder, JwtProvider jwtProvider) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.jwtProvider = jwtProvider;
    }
    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginUser loginUser, BindingResult bidBindingResult){
        if(bidBindingResult.hasErrors())
            return new ResponseEntity<>(new MenssageScurity("Revise los datos de sus credenciales"+bidBindingResult.getFieldError()), HttpStatus.BAD_REQUEST);
        try {
                UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(loginUser.getEmail(), loginUser.getPassword());
                Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                String jwt = jwtProvider.generateToken(authentication);
                JwtDto jwtDto = new JwtDto(jwt);
                return new ResponseEntity<>(jwtDto, HttpStatus.OK);
        } catch (Exception e) {
                return new ResponseEntity<>(new MenssageScurity("Revise sus credenciales - "+ e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
