package com.elegancy.orderedservice.web;

import com.elegancy.orderedservice.dto.OrderRequestDto;
import com.elegancy.orderedservice.dto.OrderResponseDto;
import com.elegancy.orderedservice.services.OrderService;
import com.elegancy.orderedservice.services.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class OrderAPI {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping(path = "/orders")
    public List<OrderResponseDto> allOrders(){
        return orderService.allOrders();
    }

    @GetMapping(path = "/orders/{id}")
    public OrderResponseDto getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @PostMapping(path = "/orders")
    public OrderResponseDto saveOrder(@RequestBody OrderRequestDto requestDto){
        return orderService.saveOrder(requestDto);
    }

    @PutMapping(path = "/orders/{id}")
    public OrderResponseDto updateOrder(@PathVariable Long id,@RequestBody OrderRequestDto requestDto){
        return orderService.updateOrder(id, requestDto);
    }

    @DeleteMapping(path = "/orders/{id}")
    public  void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }

    @ExceptionHandler
    public ResponseEntity<String> orderException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
