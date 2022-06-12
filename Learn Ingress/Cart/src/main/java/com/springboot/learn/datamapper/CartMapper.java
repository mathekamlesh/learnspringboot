package com.springboot.learn.datamapper;

import com.springboot.learn.dto.GetCartProductDetail;
import com.springboot.learn.dto.GetCartResponse;
import com.springboot.learn.dto.response.Body;
import com.springboot.learn.dto.response.Header;
import com.springboot.learn.dto.response.Response;
import com.springboot.learn.entity.Cart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class CartMapper {
    public Response<GetCartResponse> createSuccessResponse(Cart cart){
        List<GetCartProductDetail> cartDetails = new ArrayList<>();
        cart.getCartDetail().forEach( cartDetail -> {
            GetCartProductDetail getCartProductDetail = new GetCartProductDetail().builder()
                    .cartDetailId(cartDetail.getCartDetailId())
                    .price(cartDetail.getPrice())
                    .quantity(cartDetail.getQuantity())
                    .productId(cartDetail.getProductId())
                    .build();
            cartDetails.add(getCartProductDetail);
        });

        GetCartResponse getCartResponse = new GetCartResponse().builder()
                .cartDetail(cartDetails)
                .cartId(cart.getCartId())
                .addedOn(cart.getAddedOn())
                .updatedOn(cart.getUpdatedOn())
                .type(cart.getType())
                .build();
        Response<GetCartResponse> response = new Response<>();
        Body<GetCartResponse> body = new Body<>();
        body.setData(getCartResponse);
        Header header = new Header().builder()
                .status(1)
                .message("Success")
                .messageCode("1")
                .build();
        response.setBody(body);
        response.setHeader(header);
        return response;
    }

    public Response<GetCartResponse> createFailureResponse(){
        return null;
    }

    public Response<GetCartResponse> createInternalErrorResponse(){
        return null;
    }
}
