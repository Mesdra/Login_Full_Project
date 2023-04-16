package br.com.mesdra.springapi.controller;


import br.com.mesdra.springapi.service.model.response.VersionResponse;
import br.com.mesdra.springapi.service.VersionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/versao")
public class VersionController {

    private final VersionService service;

    @GetMapping()
    public ResponseEntity<VersionResponse> version() {
        return ResponseEntity.ok().body(service.getVersion());
    }

}
