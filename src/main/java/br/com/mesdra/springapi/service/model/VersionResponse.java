package br.com.mesdra.springapi.service.model;

import lombok.Builder;

@Builder
public record VersionResponse(String versao,String nome) {
}
