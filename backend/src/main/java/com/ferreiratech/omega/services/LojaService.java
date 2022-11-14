package com.ferreiratech.omega.services;

import com.ferreiratech.omega.repositories.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LojaService {

    @Autowired
    private LojaRepository repository;

    public Boolean validarSenha(String cnpj, String senha) {
        return repository.validarSenha(cnpj, senha).isPresent();
    }
}
