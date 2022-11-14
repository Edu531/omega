package com.ferreiratech.omega.services;

import com.ferreiratech.omega.entities.Nota;
import com.ferreiratech.omega.repositories.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class NotaService {

    @Autowired
    private NotaRepository repository;

    public List<Nota> getByCnpj(String cnpj) {
        return repository.getByCnpj(cnpj);
    }

    public Nota salvar(Nota nota) {
        nota.setData(new Date());
        return repository.save(nota);
    }
}
