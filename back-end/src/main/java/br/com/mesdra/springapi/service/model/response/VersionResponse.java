package br.com.mesdra.springapi.service.model.response;

import lombok.Builder;

@Builder
public record VersionResponse(String versao,String nome) {
}
