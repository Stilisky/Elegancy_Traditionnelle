package com.elegancy.elegancyportail.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor
public class ClientBean {
    private Long id;
    private String prenom;
    private String nom;
    private Date dateNaissance;
    private String telephone;
    private String adresse;
}
