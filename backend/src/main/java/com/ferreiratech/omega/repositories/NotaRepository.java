package com.ferreiratech.omega.repositories;

import com.ferreiratech.omega.entities.Nota;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotaRepository extends JpaRepository<Nota, Long> {

    @Query("SELECT nota FROM Nota nota where nota.loja.cnpj = :cnpj")
    List<Nota> getByCnpj(String cnpj);
}
