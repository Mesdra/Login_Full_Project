package br.com.mesdra.springapi.service;


import br.com.mesdra.springapi.service.model.response.VersionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class VersionService {

    @Value("${app.version}")
    private String appVersion;

    @Value("${app.name}")
    private String appName;

    public VersionResponse getVersion(){
        return VersionResponse.builder().nome(appName).versao(appVersion).build();
    }

}
