package com.ferreiratech.omega.services;

import com.ferreiratech.omega.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repository;

    public Boolean validarSenha(String cnpj, String senha) {
        return repository.validarSenha(cnpj, senha).isPresent();
    }
}
