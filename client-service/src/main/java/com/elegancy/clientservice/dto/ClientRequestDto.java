package com.elegancy.clientservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class ClientRequestDto {
    @JsonProperty(value = "id")
    private Long id;
    @JsonProperty(value = "prenom")
    private String prenom;
    @JsonProperty(value = "nom")
    private String nom;
    @JsonProperty(value = "datenaisc")
    private Date dateNaissance;
    @JsonProperty(value = "telephone")
    private String telephone;
    @JsonProperty(value = "adresse")
    private String adresse;
}
