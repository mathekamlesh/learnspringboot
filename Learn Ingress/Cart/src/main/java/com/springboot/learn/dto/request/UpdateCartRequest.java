package com.springboot.learn.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCartRequest {
    @JsonProperty("CartId")
    private Long cartId;
    @JsonProperty("Type")
    private Integer type;
    @JsonProperty("Products")
    private List<CartProduct> cartProducts;
}
