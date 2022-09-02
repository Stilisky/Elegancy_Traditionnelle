package com.elegancy.orderedservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "ordered")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ordereddate")
    private Date orderedDate;
    @Column(name = "destination")
    private String destination;
    @Column(name = "orderstatus")
    private OrderStatus orderStatus;

}
