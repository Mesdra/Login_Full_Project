package br.com.mesdra.springapi.service.model.request;

import br.com.mesdra.springapi.validator.TrimString;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @TrimString
        @NotBlank(message = "Email não pode ser vazio")
        @Email(message = "Email Invalido")
        String email,
        @TrimString
        @NotBlank(message = "nome não pode ser vazio")
        @Size(min = 3, max = 40, message = "nome deve conter entre 3 e 40 caracteres")
        String nome,
        @TrimString
        @NotBlank(message = "Senha não pode ser vazio")
        @Size(min = 3, max = 20, message = "Senha deve conter entre 3 e 20 caracteres")
        String senha
) {
}
