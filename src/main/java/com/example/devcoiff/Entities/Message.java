package com.example.devcoiff.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_mess;
    private String contenu;

   @ManyToOne
   @JoinColumn(name="client_id")
   private Utilisateur utilisateur ;

    @ManyToOne
    @JoinColumn(name="coiffeur_id")
    private Utilisateur utilisateurs ;
}
