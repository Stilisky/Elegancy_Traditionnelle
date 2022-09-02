package com.elegancy.deliveryservice.services;

import com.elegancy.deliveryservice.dto.DeliveryRequestDto;
import com.elegancy.deliveryservice.dto.DeliveryResponseDto;
import com.elegancy.deliveryservice.entities.Delivery;
import com.elegancy.deliveryservice.mappers.DeliveryMapper;
import com.elegancy.deliveryservice.repositories.DeliveryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryRepo repository;
    @Override
    public DeliveryResponseDto getDeliveryById(Long id) {

        return DeliveryMapper.deliveryToDeliveryResponseDto(repository.findById(id).get());
    }

    @Override
    public List<DeliveryResponseDto> allDeliveries() {
        List<Delivery> deliveries = repository.findAll();
        List<DeliveryResponseDto> responseDtos = new ArrayList<>();
        deliveries.forEach(delivery ->
                responseDtos.add(DeliveryMapper.deliveryToDeliveryResponseDto(delivery)));
        return responseDtos;
    }

    @Override
    public DeliveryResponseDto saveDelivery(DeliveryRequestDto requestDto) {
        Delivery delivery = DeliveryMapper.deliveryResponseDtoToDelivery(requestDto);
        if (delivery.getDeliveryDate() == null){
            delivery.setDeliveryDate(new Date());
        }
        return DeliveryMapper.deliveryToDeliveryResponseDto(repository.save(delivery));
    }

    @Override
    public DeliveryResponseDto updateDelivery(DeliveryRequestDto requestDto) {
        Delivery delivery = DeliveryMapper.deliveryResponseDtoToDelivery(requestDto);
        if (delivery.getDeliveryStatus() != requestDto.getDeliveryStatus()){
            delivery.setDeliveryStatus(requestDto.getDeliveryStatus());
        }
        if (delivery.getClientName() != requestDto.getClientName()){
            delivery.setClientName(requestDto.getClientName());
        }
        if (delivery.getDeliveryDate() != requestDto.getDeliveryDate()){
            delivery.setDeliveryDate(requestDto.getDeliveryDate());
        }
        return DeliveryMapper.deliveryToDeliveryResponseDto(delivery);
    }

    @Override
    public void deleteDelivery(Long id) {
        repository.deleteById(id);
    }
}
