package com.elegancy.clientservice.services;

import com.elegancy.clientservice.dto.ClientRequestDto;
import com.elegancy.clientservice.dto.ClientResponseDto;
import com.elegancy.clientservice.entities.Client;
import com.elegancy.clientservice.mappers.ClientMapper;
import com.elegancy.clientservice.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository repository;
    @Override
    public List<ClientResponseDto> allClients() {
        List<Client> clients = repository.findAll();
        List<ClientResponseDto> responseDtos = new ArrayList<>();
        clients.forEach(client ->
                responseDtos.add(ClientMapper.clientToClientResponse(client)));
        return responseDtos;
    }

    @Override
    public ClientResponseDto getClientById(Long id) {
        Client client = repository.findById(id).get();
        return ClientMapper.clientToClientResponse(client);
    }

    @Override
    public ClientResponseDto saveClient(ClientRequestDto requestDto) {
        Client client = ClientMapper.clientResponseDtoToClient(requestDto);
        Client clisave = repository.save(client);
        return ClientMapper.clientToClientResponse(clisave);
    }

    @Override
    public void deleteClient(Long id) {
        repository.deleteById(id);
    }
}
