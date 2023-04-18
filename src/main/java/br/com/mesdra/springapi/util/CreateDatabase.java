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

    // senha dos usuários : admin
    public static final String PASSWORD_ADMIN = "$2a$12$8nXSix7CIdlsVZbG3r8H8OALCL0mQgbJX1i6Dqf9JDOd4jGPpzQHW";
    // senha dos usuários : user
    public static final String PASSWORD_USER = "$2a$12$i90fgk9G0KK1XVPeBn0M3esGUIUDDIys3GlMj4lqO/vFIcxJPSJ4K";
    private final UserRepository repository;

    @Bean
    public void fillDataBase() {

        User userAdm = User.builder().nome("admin").email("admin@hotmail.com").senha(PASSWORD_ADMIN).perfil(Perfil.ADMIN).build();
        User user = User.builder().nome("user").email("user@hotmail.com").senha(PASSWORD_USER).perfil(Perfil.USUARIO).build();

        repository.save(userAdm);
        repository.save(user);

    }
}
