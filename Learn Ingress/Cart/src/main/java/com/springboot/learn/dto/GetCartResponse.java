package com.springboot.learn.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCartResponse {
    @JsonProperty("CartId")
    Long cartId;
    @JsonProperty("AddedOn")
    Date addedOn;
    @JsonProperty("UpdatedOn")
    Date updatedOn;
    @JsonProperty("Type")
    Integer type;
    @JsonProperty("Products")
    List<GetCartProductDetail> cartDetail;
}
