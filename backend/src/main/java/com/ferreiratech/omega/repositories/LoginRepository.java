package com.ferreiratech.omega.repositories;

import com.ferreiratech.omega.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {

    @Query("SELECT login FROM Login login WHERE login.cnpj = :cnpj AND login.senha = :senha")
    Optional<Login> validarSenha(String cnpj, String senha);
}
