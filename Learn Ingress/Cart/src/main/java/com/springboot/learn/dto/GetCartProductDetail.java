package com.springboot.learn.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetCartProductDetail {
    @JsonProperty("Id")
    Long cartDetailId;
    @JsonProperty("ProductId")
    Long productId;
    @JsonProperty("Quantity")
    Long quantity;
    @JsonProperty("Price")
    Long price;
}
