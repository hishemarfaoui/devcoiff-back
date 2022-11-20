package com.example.devcoiff.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Date_de_travail")
public class Date_de_travail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_travail;
    private String jours;
    private LocalDate date_jours;

   @OneToMany (cascade = CascadeType.ALL, mappedBy = "date_de_travail" )
   @JsonIgnore
    private List<Utilisateur> utilisateurs;

   @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "datetravail_créneaux", joinColumns = @JoinColumn(name = "id_travail"),inverseJoinColumns = @JoinColumn(name = "id_cre")
           ,uniqueConstraints = { @UniqueConstraint(columnNames = { "id_travail", "id_cre" }) } )
    private List<Créneaux> créneaux ;

}
