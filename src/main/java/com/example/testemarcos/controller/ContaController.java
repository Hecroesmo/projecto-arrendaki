package com.example.testemarcos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.testemarcos.model.Conta;
import com.example.testemarcos.model.TipoConta;
import com.example.testemarcos.repository.ContaRepository;
import com.example.testemarcos.repository.TipoContaRepository;
import com.example.testemarcos.utility.JwtUtility;

@RestController
@RequestMapping("/api/usuario")
public class ContaController {

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ContaRepository contaRepo;

    @Autowired
    private TipoContaRepository tipoContaRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conta salvar(@RequestBody Conta conta) {
        TipoConta tipoConta = tipoContaRepo.findById(conta.getTipoConta().getPkTypeOfAccount()).get();
        conta.setTipoConta(tipoConta);
        String encodedPassword = new BCryptPasswordEncoder().encode(conta.getPassword());
        conta.setPassword(encodedPassword);
        return contaRepo.save(conta);
    }

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
