package br.com.mesdra.springapi.controller;

import br.com.mesdra.springapi.service.AuthenticationService;
import br.com.mesdra.springapi.service.model.request.LoginRequest;
import br.com.mesdra.springapi.service.model.request.UserRequest;
import br.com.mesdra.springapi.service.model.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserRequest request) {
        return ResponseEntity.ok().body(service.register(request));

    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok().body(service.login(request));
    }

}
