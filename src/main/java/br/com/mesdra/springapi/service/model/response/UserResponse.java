package br.com.mesdra.springapi.service.model.response;

import lombok.Builder;

@Builder
public record UserResponse(String nome, String perfil) {
}
