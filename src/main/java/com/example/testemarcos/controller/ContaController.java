package com.example.testemarcos.controller;

import com.example.testemarcos.model.Conta;
import com.example.testemarcos.utility.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class ContaController {

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/autenticar")
    public String autenticarPegarToken(@RequestBody Conta conta){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(conta.getEmail(),conta.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtUtility.gerarToken(conta.getEmail());
        }
        else {
            throw new UsernameNotFoundException("Requisição Invalida do Conta");
        }


    }




}
