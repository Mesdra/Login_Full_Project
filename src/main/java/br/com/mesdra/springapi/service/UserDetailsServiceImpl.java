package br.com.mesdra.springapi.service;

import br.com.mesdra.springapi.repository.UserRepository;
import br.com.mesdra.springapi.repository.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


    private UserRepository repo;

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> userOPT = repo.findByEmail(email);

        if (userOPT.isEmpty()) {
            throw new UsernameNotFoundException("Usuario não encontrado "+ email);
        } else {
            return userOPT.get();
        }
    }

}
