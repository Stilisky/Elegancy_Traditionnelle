package com.elegancy.elegancyportail.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProductBean {
    private Long id;
    private String name;
    private double price;
    private double quantity;
    private String image;
}
