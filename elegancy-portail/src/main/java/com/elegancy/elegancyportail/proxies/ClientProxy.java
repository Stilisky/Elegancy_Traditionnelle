package com.elegancy.elegancyportail.proxies;

import com.elegancy.elegancyportail.beans.ClientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ZUUL-SERVER")
public interface ClientProxy {
    @GetMapping(path = "/client-service/api/clients")
    public List<ClientBean> allClients();
    @GetMapping(path = "/client-service/api/clients/{id}")
    public ClientBean getClientById(@PathVariable Long id);
    @PostMapping(path = "/client-service/api/clients")
    public ClientBean saveClient(@RequestBody ClientBean requestDto);
    @DeleteMapping(path = "/client-service/api/clients/{id}")
    public void deleteClient(@PathVariable Long id);
}
