package com.ferreiratech.omega.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/teste")
public class UserController {

    @GetMapping
    public String teste() {
        return "teste";
    }
}
