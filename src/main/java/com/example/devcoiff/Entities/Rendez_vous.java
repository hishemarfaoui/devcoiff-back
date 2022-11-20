package com.example.devcoiff.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Rendez_vous")

public class Rendez_vous implements Serializable {
    public enum Etat  {
        Pending,
        Accepted,
        Refused
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_rv;
    private LocalDate date_rv ;
    private Etat status ;

   @ManyToOne
   @JoinColumn(name="client_id")
   private Utilisateur client ;

    @ManyToOne
    @JoinColumn(name="coiffeur_id")
    private Utilisateur coiffeur ;
}
