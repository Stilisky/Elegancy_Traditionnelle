package com.elegancy.deliveryservice.mappers;

import com.elegancy.deliveryservice.dto.DeliveryRequestDto;
import com.elegancy.deliveryservice.dto.DeliveryResponseDto;
import com.elegancy.deliveryservice.entities.Delivery;

public class DeliveryMapper {
    public static Delivery deliveryResponseDtoToDelivery(DeliveryRequestDto requestDto){
        Delivery delivery = new Delivery();
        delivery.setDeliveryDate(requestDto.getDeliveryDate());
        delivery.setDeliveryStatus(requestDto.getDeliveryStatus());
        delivery.setId(requestDto.getId());
        delivery.setClientName(requestDto.getClientName());
        return delivery;
    }
    public static DeliveryResponseDto deliveryToDeliveryResponseDto(Delivery delivery){
        DeliveryResponseDto responseDto = new DeliveryResponseDto();
        responseDto.setDeliveryDate(delivery.getDeliveryDate());
        responseDto.setDeliveryStatus(delivery.getDeliveryStatus());
        responseDto.setClientName(delivery.getClientName());
        responseDto.setId(delivery.getId());
        return responseDto;
    }
}
