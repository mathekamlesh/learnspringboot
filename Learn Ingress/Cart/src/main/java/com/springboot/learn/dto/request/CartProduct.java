package com.springboot.learn.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartProduct {
    @JsonProperty("ProductId")
    private Long productId;
    @JsonProperty("Price")
    private Long price;
    @JsonProperty("Quantity")
    private Long quantity;
}
