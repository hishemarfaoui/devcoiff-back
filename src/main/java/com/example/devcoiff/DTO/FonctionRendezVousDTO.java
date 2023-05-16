package com.example.devcoiff.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class FonctionRendezVousDTO {
    private String nom;
    private Long nombreDeRv;
    public FonctionRendezVousDTO(String nomFonction, Long nombreRv) {
        this.nom = nomFonction;
        this.nombreDeRv = nombreRv;
    }
}
