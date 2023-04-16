package br.com.mesdra.springapi.service.model.request;

public record LoginRequest(
        String email,
        String senha
) {
}
