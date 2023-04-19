package br.com.mesdra.springapi.controller;

import br.com.mesdra.springapi.service.model.response.VersionResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class VersionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${app.version}")
    private String appVersion;

    @Value("${app.name}")
    private String appName;

    @Test
    void version() throws Exception {

        MvcResult result = mockMvc.perform(get("/versao")).andExpect(status().isOk()).andReturn();
        VersionResponse resp = new Gson().fromJson(result.getResponse().getContentAsString(),VersionResponse.class);
        Assertions.assertEquals(resp.nome(), appName);
        Assertions.assertEquals(resp.versao(), appVersion);

    }
}