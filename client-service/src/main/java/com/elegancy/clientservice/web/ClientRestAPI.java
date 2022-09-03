package com.elegancy.clientservice.web;

import com.elegancy.clientservice.dto.ClientRequestDto;
import com.elegancy.clientservice.dto.ClientResponseDto;
import com.elegancy.clientservice.services.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ClientRestAPI {
    @Autowired
    private ClientServiceImpl clientService;

    @GetMapping(path = "/clients")
    public List<ClientResponseDto> allClients(){
        return clientService.allClients();
    }

    @GetMapping(path = "/clients/{id}")
    public ClientResponseDto getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping(path = "/clients")
    public ClientResponseDto saveClient(@RequestBody ClientRequestDto requestDto){
        return clientService.saveClient(requestDto);
    }

    @DeleteMapping(path = "/clients/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> clientException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
