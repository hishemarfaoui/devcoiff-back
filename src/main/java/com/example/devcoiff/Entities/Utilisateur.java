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
@ToString//@AllArgsConstructor
@Table(name = "Utilisateur")

public class Utilisateur implements Serializable {

    public enum Roles {
        ROLE_USER,
        ROLE_ADMIN
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(nullable = false)
//    updatable = false
    private Long id_utilis;
    // @Column(nullable = false)
    private String name ;
    // @Column(nullable = false)
    private String lastname ;
    //   @Column(nullable = false)

    private String phone ;
    // @Column(nullable = false)


    private String email ;
    //  @Column(nullable = false)
    private String username ;
    //  @Column(nullable = false)
    private String password ;
    private Roles role ;
    //  @Column(nullable = false)
    private String adresse ;
      @Column(nullable = true)

    private double latitude;
    @Column(nullable = true)

    private double longitude;




    @OneToMany (mappedBy = "client" , cascade = CascadeType.ALL)
   @JsonIgnore
   private List<Rendez_vous> rendez_vous;

    @OneToMany (mappedBy = "coiffeur" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Rendez_vous> rendezVous;

   @OneToMany (mappedBy = "utilisateur" , cascade = CascadeType.ALL)
    @JsonIgnore
   private List<Message> messages;

    @OneToMany (mappedBy = "utilisateurs" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Message> message;
//
   @ManyToOne
   private Date_de_travail date_de_travail ;

    @ManyToOne
    private Fonction fonction ;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_service", joinColumns = @JoinColumn(name = "id_utilis"),inverseJoinColumns = @JoinColumn(name = "id_ser"),
            uniqueConstraints = { @UniqueConstraint(columnNames = { "id_utilis", "id_ser" }) })
    private List<Service> services ;

    @OneToMany (mappedBy = "fournisseurs" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Créneaux> créneaux;
}
