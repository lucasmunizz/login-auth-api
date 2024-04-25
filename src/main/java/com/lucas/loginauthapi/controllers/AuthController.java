package com.lucas.loginauthapi.controllers;


import com.lucas.loginauthapi.domain.user.User;
import com.lucas.loginauthapi.dto.LoginRequestDTO;
import com.lucas.loginauthapi.dto.ResponseDTO;
import com.lucas.loginauthapi.infra.security.TokenService;
import com.lucas.loginauthapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final TokenService tokenService;

    public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO body){
        User user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if (encoder.matches(user.getPassword(), body.password())){
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getName(), token));
        }

        return ResponseEntity.badRequest().build();
    }

}
