package com.elegancy.orderedservice.mappers;

import com.elegancy.orderedservice.dto.OrderRequestDto;
import com.elegancy.orderedservice.dto.OrderResponseDto;
import com.elegancy.orderedservice.entities.Order;

public class OrderMapper {
    public static OrderResponseDto orderToOrderResponseDto(Order order){
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setDestination(order.getDestination());
        responseDto.setOrderedDate(order.getOrderedDate());
        responseDto.setOrderStatus(order.getOrderStatus());
        return responseDto;
    }

    public static Order orderResponseDtoToOrder(OrderRequestDto requestDto){
        Order order = new Order();
        order.setId(requestDto.getId());
        order.setDestination(requestDto.getDestination());
        order.setOrderedDate(requestDto.getOrderedDate());
        order.setOrderStatus(requestDto.getOrderStatus());
        return order;
    }
}
