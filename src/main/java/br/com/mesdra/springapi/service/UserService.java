package br.com.mesdra.springapi.service;

import br.com.mesdra.springapi.repository.UserRepository;
import br.com.mesdra.springapi.repository.model.User;
import br.com.mesdra.springapi.service.model.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserResponse findByEmail(String email) {
        Optional<User> userOPT = repository.findByEmail(email);
        if (userOPT.isPresent()) {
            return UserResponse.builder().nome(userOPT.get().getNome()).perfil(userOPT.get().getPerfil().getDescricao()).build();
        } else {
            throw new UsernameNotFoundException("Usuário com email {} não foi encontrado" + email);
        }
    }

}
