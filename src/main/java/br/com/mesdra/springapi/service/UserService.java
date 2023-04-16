package br.com.mesdra.springapi.service;

import br.com.mesdra.springapi.repository.UserRepository;
import br.com.mesdra.springapi.service.model.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserResponse findByEmail(String email){
        return null;
    }


}
