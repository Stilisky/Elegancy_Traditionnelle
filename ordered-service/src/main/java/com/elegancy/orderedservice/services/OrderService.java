package com.elegancy.orderedservice.services;

import com.elegancy.orderedservice.dto.OrderRequestDto;
import com.elegancy.orderedservice.dto.OrderResponseDto;
import com.elegancy.orderedservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

public interface OrderService {

    public List<OrderResponseDto> allOrders();
    public OrderResponseDto getOrderById(Long id);
    public OrderResponseDto saveOrder(OrderRequestDto requestDto);
    public OrderResponseDto updateOrder(Long id, OrderRequestDto requestDto);
    public void deleteOrder(Long id);
}
