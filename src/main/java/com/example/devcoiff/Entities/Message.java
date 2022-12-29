package com.example.devcoiff.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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
    private Integer sender;
    private Date timestamp;

   @ManyToOne
   @JoinColumn(name="client_id")
   private Utilisateur utilisateur ;

    @ManyToOne
    @JoinColumn(name="coiffeur_id")
    private Utilisateur utilisateurs ;
}
