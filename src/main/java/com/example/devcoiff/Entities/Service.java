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
@Table(name = "Service")
public class Service implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ser;
    private String nomService ;
    private String description ;
    @Lob
    private String img ;

    @OneToMany (mappedBy = "service" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Image> images;

//    @OneToMany (mappedBy = "service" , cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<Utilisateur> utilisateurs;
}
