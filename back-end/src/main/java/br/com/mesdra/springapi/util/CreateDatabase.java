package br.com.mesdra.springapi.util;

import br.com.mesdra.springapi.repository.UserRepository;
import br.com.mesdra.springapi.repository.model.User;
import br.com.mesdra.springapi.repository.model.enumerate.Perfil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CreateDatabase {

    // senha do usuário : admin
    public static final String PASSWORD_ADMIN = "$2a$12$8nXSix7CIdlsVZbG3r8H8OALCL0mQgbJX1i6Dqf9JDOd4jGPpzQHW";
    // senha do usuário : user
    public static final String PASSWORD_USER = "$2a$12$i90fgk9G0KK1XVPeBn0M3esGUIUDDIys3GlMj4lqO/vFIcxJPSJ4K";
    private final UserRepository repository;

    @Bean
    public void fillDataBase() {

        List<User> users = new ArrayList<>();

        String mail = "admin@hotmail.com";
        String mail2 = "user@hotmail.com";
        Optional<User> userOpt = repository.findByEmail(mail);
        Optional<User> userOpt2 = repository.findByEmail(mail2);
        if (userOpt.isEmpty())
            users.add(User.builder().nome("admin").email(mail).senha(PASSWORD_ADMIN).perfil(Perfil.ADMIN).build());
        if (userOpt2.isEmpty())
            users.add(User.builder().nome("user").email(mail2).senha(PASSWORD_USER).perfil(Perfil.USUARIO).build());
        repository.saveAll(users);
    }
}
