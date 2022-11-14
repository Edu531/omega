package com.ferreiratech.omega.controllers;

import com.ferreiratech.omega.entities.Login;
import com.ferreiratech.omega.entities.Nota;
import com.ferreiratech.omega.services.LoginService;
import com.ferreiratech.omega.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping(value = "/teste")
public class UserController {

    @Autowired
    LoginService loginService;

    @Autowired
    NotaService notaService;

    @GetMapping
    public String teste() {
        return "teste";
    }

    @PostMapping(value = "/login")
    public Boolean login(@RequestBody Login login) {
        return loginService.validarSenha(login.getCnpj(), login.getSenha());
    }

    @GetMapping(value = "/arquivo")
    public ResponseEntity downloadFile() {
        Path path = Paths.get("C:\\Users\\eduardo.ferreira\\Downloads\\11234.pdf");
        UrlResource resource = null;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/pdf"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping(value = "/listar/{cnpj}")
    public ResponseEntity<List<Nota>> listar(@PathVariable String cnpj) {
        return ResponseEntity.ok().body(notaService.getByCnpj(cnpj));
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity salvar(@RequestBody Nota nota) {
        return ResponseEntity.ok().body(notaService.salvar(nota));
    }
}
