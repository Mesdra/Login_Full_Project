package br.com.mesdra.springapi.controller;


import br.com.mesdra.springapi.service.UserService;
import br.com.mesdra.springapi.service.model.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UserController {

    private final UserService service;
    @GetMapping("/buscar")
    public ResponseEntity<UserResponse> adminRequest(Authentication auth) {
        return ResponseEntity.ok().body(service.findByEmail(auth.getName()));
    }

}
