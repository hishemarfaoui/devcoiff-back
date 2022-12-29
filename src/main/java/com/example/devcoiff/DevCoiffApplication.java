package com.example.devcoiff;

import com.example.devcoiff.Entities.Fonction;
import com.example.devcoiff.Entities.Utilisateur;
import com.example.devcoiff.Repositories.UtilisateurRepository;
import com.example.devcoiff.Services.IFonction;
import com.example.devcoiff.Services.IUtilisateur;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@AllArgsConstructor
@SpringBootApplication
public class DevCoiffApplication implements CommandLineRunner {
    private IFonction iFonction;
    private IUtilisateur iUtilisateur;


    private PasswordEncoder bcryptPasswordEncoder;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    public static void main(String[] args) {
        SpringApplication.run(DevCoiffApplication.class, args);
    }
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

    @Override
    public void run(String... args) throws Exception {
        boolean existAdmin = false;
        Fonction Client = new Fonction();
        Fonction Coiffeur = new Fonction();
        Coiffeur.setNom(Fonction.Fonctions.coiffeur);
        Client.setNom(Fonction.Fonctions.client);
        if (iFonction.getAllFonction().isEmpty()){
            iFonction.ajoutFonction(Client);
            iFonction.ajoutFonction(Coiffeur);
        }



        Utilisateur e = new Utilisateur();
        e.setRole(Utilisateur.Roles.ROLE_ADMIN);
        e.setUsername("admin");
        e.setPassword("admin");
        e.setPassword(bcryptPasswordEncoder.encode(e.getPassword()));

        List<Utilisateur> listuti =  iUtilisateur.getAllUtilisateur();
        for (Utilisateur utilisateur: listuti) {
            if (!utilisateur.getUsername().equals( e.getUsername()))	{
                existAdmin = false;
            }else {
                existAdmin =true;
                break;
            }
        }
        if (!existAdmin){
            utilisateurRepository.save(e);
        }

//        Authentication authentication = authManager
//                .authenticate(new UsernamePasswordAuthenticationToken
//                        ("admin","admin"));
//
//        String token = tokenService.generateToken(authentication);
//        System.out.println(token);

    }


}
