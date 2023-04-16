package br.com.mesdra.springapi.service;

import br.com.mesdra.springapi.repository.UserRepository;
import br.com.mesdra.springapi.repository.model.User;
import br.com.mesdra.springapi.repository.model.enumerate.Perfil;
import br.com.mesdra.springapi.service.model.request.LoginRequest;
import br.com.mesdra.springapi.service.model.request.UserRequest;
import br.com.mesdra.springapi.service.model.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    //Beans
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(UserRequest request) {
        var user = User.builder().nome(request.nome())
                       .email(request.email())
                       .perfil(Perfil.toEnum(2))
                       .senha(passwordEncoder.encode(request.senha()))
                       .build();
        repository.save(user);
        return AuthenticationResponse.builder().token(jwtService.generateToken(user)).build();
    }

    public AuthenticationResponse login(LoginRequest request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.senha()));
        var user = repository.findByEmail(request.email()).orElseThrow();
        return AuthenticationResponse.builder().token(jwtService.generateToken(user)).build();
    }
}
