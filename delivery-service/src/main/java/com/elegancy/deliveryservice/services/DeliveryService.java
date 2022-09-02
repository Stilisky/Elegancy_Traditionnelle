package com.elegancy.deliveryservice.services;

import com.elegancy.deliveryservice.dto.DeliveryRequestDto;
import com.elegancy.deliveryservice.dto.DeliveryResponseDto;

import java.util.List;

public interface DeliveryService {
    DeliveryResponseDto getDeliveryById(Long id);
    List<DeliveryResponseDto> allDeliveries();
    DeliveryResponseDto saveDelivery(DeliveryRequestDto requestDto);
    DeliveryResponseDto updateDelivery(DeliveryRequestDto requestDto);
    void deleteDelivery(Long id);
}
