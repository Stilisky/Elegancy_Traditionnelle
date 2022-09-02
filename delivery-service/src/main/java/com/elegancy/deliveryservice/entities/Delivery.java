package com.elegancy.deliveryservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "delivery")
public class Delivery {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;
    @Column(name = "deliverydate")
    private Date deliveryDate;
    @Column(name = "name")
    private String clientName;
    @Column(name = "deliverystatus")
    private DeliveryStatus deliveryStatus;

}
