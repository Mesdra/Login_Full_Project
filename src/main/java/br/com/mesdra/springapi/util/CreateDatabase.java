package br.com.mesdra.springapi.util;

import br.com.mesdra.springapi.repository.UserRepository;
import br.com.mesdra.springapi.repository.model.User;
import br.com.mesdra.springapi.repository.model.enumerate.Perfil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateDatabase {


    public static final String PASSWORD = "123456";
    private final UserRepository repository;

    @Bean
    public void fillDataBase(){

        User userVini = User.builder().nome("Vinicius").senha(PASSWORD).perfil(Perfil.ADMIN).build();
        User user = User.builder().nome("Usuario").senha(PASSWORD).perfil(Perfil.USUARIO).build();

        repository.save(userVini);
        repository.save(user);

    }
}
