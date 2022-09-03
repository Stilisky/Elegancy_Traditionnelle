package com.elegancy.clientservice.mappers;

import com.elegancy.clientservice.dto.ClientRequestDto;
import com.elegancy.clientservice.dto.ClientResponseDto;
import com.elegancy.clientservice.entities.Client;

public class ClientMapper {
    public static ClientResponseDto clientToClientResponse(Client client){
        ClientResponseDto responseDto = new ClientResponseDto();
        responseDto.setAdresse(client.getAdresse());
        responseDto.setId(client.getId());
        responseDto.setDateNaissance(client.getDateNaissance());
        responseDto.setNom(client.getNom());
        responseDto.setPrenom(client.getPrenom());
        responseDto.setTelephone(client.getTelephone());
        return responseDto;
    }
    public static Client clientResponseDtoToClient(ClientRequestDto requestDto){
        Client client = new Client();
        client.setAdresse(requestDto.getAdresse());
        client.setId(requestDto.getId());
        client.setNom(requestDto.getNom());
        client.setPrenom(requestDto.getPrenom());
        client.setTelephone(requestDto.getTelephone());
        client.setDateNaissance(requestDto.getDateNaissance());
        return client;
    }
}
