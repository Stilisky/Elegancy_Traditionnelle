package com.elegancy.categoryservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class CategoryRequestDTO {
    @JsonProperty(value = "id")
    private Long id;
    @JsonProperty(value = "catname")
    private String catName;
}
