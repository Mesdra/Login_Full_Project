package br.com.mesdra.springapi.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<String> adminRequest() {
        return ResponseEntity.ok().body("Você é um administrado autenticado");
    }

    @GetMapping("/")
    public ResponseEntity<String> userRequest() {
        return ResponseEntity.ok().body("Você é um usuario autenticado");
    }

}
