package com.example.devcoiff.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "fonctions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Fonction implements Serializable {

    public enum Fonctions {
        client,
        coiffeur
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_fonction ;
    @Enumerated(EnumType.STRING)
    private Fonctions nom ;

    @OneToMany (mappedBy = "fonction" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Utilisateur> utilisateurs;
}
