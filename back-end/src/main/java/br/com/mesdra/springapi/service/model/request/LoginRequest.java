package br.com.mesdra.springapi.service.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @NotBlank(message = "Email não pode ser vazio")
        @Email(message = "Email Invalido")
        String email,
        @NotBlank(message = "Senha não pode ser vazio")
        @Size(min = 3, max = 20, message = "Senha deve conter entre 3 e 20 caracteres")
        String senha
) {
}
