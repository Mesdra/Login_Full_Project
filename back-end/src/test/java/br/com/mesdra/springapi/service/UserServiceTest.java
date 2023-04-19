package br.com.mesdra.springapi.service;

import br.com.mesdra.springapi.repository.UserRepository;
import br.com.mesdra.springapi.repository.model.User;
import br.com.mesdra.springapi.repository.model.enumerate.Perfil;
import br.com.mesdra.springapi.service.model.response.UserResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    public static final String EMAIL = "test@htomail.com";
    public static final Perfil PERFIL = Perfil.toEnum(1);
    public static final String NOME = "teste";
    @Mock
    private UserRepository repository;
    @InjectMocks
    private UserService service;


    @Test
    void findByEmail() {
        when(repository.findByEmail(any(String.class)))
                .thenReturn(Optional.of(User.builder().email(EMAIL).senha("$2a$12").nome(NOME).perfil(PERFIL).build()));
        UserResponse response = service.findByEmail(EMAIL);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.nome(), NOME);
        Assertions.assertEquals(response.perfil(), PERFIL.getDescricao());

    }
}