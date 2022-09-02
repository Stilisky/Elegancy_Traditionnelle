package com.elegancy.orderedservice.services;

import com.elegancy.orderedservice.dto.OrderRequestDto;
import com.elegancy.orderedservice.dto.OrderResponseDto;
import com.elegancy.orderedservice.entities.Order;
import com.elegancy.orderedservice.exceptions.OrderNotFoundException;
import com.elegancy.orderedservice.mappers.OrderMapper;
import com.elegancy.orderedservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository repository;
    @Override
    public List<OrderResponseDto> allOrders() {
        List<Order> orders = repository.findAll();
        List<OrderResponseDto> responseDtos = new ArrayList<>();
        orders.forEach(order ->
                responseDtos.add(OrderMapper.orderToOrderResponseDto(order)));
        return responseDtos;
    }

    @Override
    public OrderResponseDto getOrderById(Long id) {
        Order order;
        try {
            order = repository.findById(id).get();
        } catch (Exception e){
            throw new OrderNotFoundException("La commande est introuvable!");
        }

        return OrderMapper.orderToOrderResponseDto(order);
    }

    @Override
    public OrderResponseDto saveOrder(OrderRequestDto requestDto) {
        Order order = OrderMapper.orderResponseDtoToOrder(requestDto);
        if (order.getOrderedDate() == null){
            order.setOrderedDate(new Date());
        }
        return OrderMapper.orderToOrderResponseDto(repository.save(order));
    }

    @Override
    public OrderResponseDto updateOrder(Long id, OrderRequestDto requestDto) {
        Order order;
        try{
            order = repository.findById(id).get();
        } catch (Exception e){
            throw new OrderNotFoundException("La commande à mettre à jours est introuvable!");
        }
        if (order.getOrderedDate() != requestDto.getOrderedDate()){
            order.setOrderedDate(requestDto.getOrderedDate());
        }
        if (order.getOrderStatus() != requestDto.getOrderStatus()){
            order.setOrderStatus(requestDto.getOrderStatus());
        }
        if (order.getDestination() != requestDto.getDestination()){
            order.setDestination(requestDto.getDestination());
        }
        return OrderMapper.orderToOrderResponseDto(order);
    }

    @Override
    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
}
