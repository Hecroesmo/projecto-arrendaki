/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.example.testemarcos.utility;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

/**
 *
 * @author fatin
 */
@Service
public class FicheiroServicoImpl implements FicheiroServico {

    @Override
    public String uploadImage(MultipartFile ficheiro) {
        
        if(ficheiro.isEmpty())
            return null;
        String nomeFicheiro = ficheiro.getOriginalFilename();
        String imagem64 = null;
        String cabecalhoBase64 = "data:image/" + nomeFicheiro.substring(nomeFicheiro.lastIndexOf(".") + 1) + ";base64,";
        try{
            byte[] imagem = ficheiro.getBytes();
            imagem64 = cabecalhoBase64 + Base64.getEncoder().encodeToString(imagem);
        }catch(IOException e){
        }
        return imagem64;
    }

}
