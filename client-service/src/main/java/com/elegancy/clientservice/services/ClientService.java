package com.elegancy.clientservice.services;


import com.elegancy.clientservice.dto.ClientRequestDto;
import com.elegancy.clientservice.dto.ClientResponseDto;

import java.util.List;

public interface ClientService {
   List<ClientResponseDto> allClients();
   ClientResponseDto getClientById(Long id);
   ClientResponseDto saveClient(ClientRequestDto requestDto);
   void deleteClient(Long id);
}
