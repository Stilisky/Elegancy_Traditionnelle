package com.elegancy.deliveryservice.web;

import com.elegancy.deliveryservice.dto.DeliveryRequestDto;
import com.elegancy.deliveryservice.dto.DeliveryResponseDto;
import com.elegancy.deliveryservice.services.DeliveryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class DeliveryAPI {
    @Autowired
    private DeliveryServiceImpl deliveryService;

    @GetMapping(path = "/deliveries")
    public List<DeliveryResponseDto> allDeliveries(){
        return deliveryService.allDeliveries();
    }

    @GetMapping(path = "/deliveries/{id}")
    public DeliveryResponseDto getDelivery(@PathVariable Long id){
        return deliveryService.getDeliveryById(id);
    }

    @PostMapping(path = "/deliveries")
    public DeliveryResponseDto saveDelivery(@RequestBody DeliveryRequestDto requestDto){
        return deliveryService.saveDelivery(requestDto);
    }

    @PutMapping(path = "/deliveries")
    public  DeliveryResponseDto updateDelivery(@RequestBody DeliveryRequestDto requestDto){
        return deliveryService.updateDelivery(requestDto);
    }

    @DeleteMapping(path = "/deliveries/{id}")
    public void deleteDelivery(@PathVariable Long id){
        deliveryService.deleteDelivery(id);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> deliveryException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
