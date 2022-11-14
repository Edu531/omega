package com.ferreiratech.omega.repositories;

import com.ferreiratech.omega.entities.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LojaRepository extends JpaRepository<Loja, Long> {

    @Query("SELECT loja FROM Loja loja WHERE loja.cnpj = :cnpj AND loja.senha = :senha")
    Optional<Loja> validarSenha(String cnpj, String senha);
}
