package br.com.mesdra.springapi.service.model.request;

public record UserRequest(
        String email,
        String nome,
        String senha
) {
}
