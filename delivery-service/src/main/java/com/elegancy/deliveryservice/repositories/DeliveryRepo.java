package com.elegancy.deliveryservice.repositories;

import com.elegancy.deliveryservice.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepo extends JpaRepository<Delivery, Long> {
}
