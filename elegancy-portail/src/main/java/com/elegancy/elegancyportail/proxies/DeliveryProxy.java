package com.elegancy.elegancyportail.proxies;

import com.elegancy.elegancyportail.beans.DeliveryBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ZUUL-SERVER")
public interface DeliveryProxy {
    @GetMapping(path = "/delivery-service/api/deliveries")
    public List<DeliveryBean> allDeliveries();
    @GetMapping(path = "/delivery-service/api/deliveries/{id}")
    public DeliveryBean getDelivery(@PathVariable Long id);
    @PostMapping(path = "/delivery-service/api/deliveries")
    public DeliveryBean saveDelivery(@RequestBody DeliveryBean requestDto);
    @PutMapping(path = "/delivery-service/api/deliveries")
    public  DeliveryBean updateDelivery(@RequestBody DeliveryBean requestDto);
    @DeleteMapping(path = "/delivery-service/api/deliveries/{id}")
    public void deleteDelivery(@PathVariable Long id);
}
