package com.example.testemarcos.controller;

import com.example.testemarcos.model.Residencia;
import com.example.testemarcos.model.Foto;
import com.example.testemarcos.repository.ResidenciaRepository;
import com.example.testemarcos.repository.FotoRepository;
import com.example.testemarcos.utility.FicheiroServicoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/houses")
public class ResidenciaController {
  @Autowired
  private ResidenciaRepository residenciaRepository;

  @Autowired
  private FotoRepository fotoRepository;

  @Autowired
  private FicheiroServicoImpl ficheiroServico;

  public Residencia save(@RequestBody Residencia residencia) {
      return residenciaRepository.save(residencia);
  }

  @PostMapping("/{id}/upload-photo")
  public ResponseEntity<String> uploadPhoto(@PathVariable Long id, @RequestParam("photoFile") MultipartFile photoFile) {
    if (photoFile.isEmpty()) {
      return new ResponseEntity<>("Please select a file to upload.", HttpStatus.BAD_REQUEST);
    }

    try {
      Residencia residencia = residenciaRepository.findById(id)
          .orElse(null);

      if (residencia != null) {
        Foto foto = new Foto();
        foto.setFileName(ficheiroServico.uploadImage(photoFile));
        foto.setResidencia(residencia);
        fotoRepository.save(foto);

        return new ResponseEntity<>("Photo uploaded and associated with the house.", HttpStatus.CREATED);
      } else {
        return new ResponseEntity<>("House not found.", HttpStatus.NOT_FOUND);
      }
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>("Failed to upload and associate the photo.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
