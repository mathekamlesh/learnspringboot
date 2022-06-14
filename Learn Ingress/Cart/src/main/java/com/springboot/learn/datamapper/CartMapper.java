package com.springboot.learn.datamapper;

import com.springboot.learn.AppContext;
import com.springboot.learn.dto.GetCartProductDetail;
import com.springboot.learn.dto.GetCartResponse;
import com.springboot.learn.dto.response.Body;
import com.springboot.learn.dto.response.Header;
import com.springboot.learn.dto.response.Response;
import com.springboot.learn.entity.Cart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class CartMapper {
    @Autowired
    private AppContext appContext;
    public Response<GetCartResponse> createSuccessResponse(Cart cart) {
        System.out.println(cart);
        List<GetCartProductDetail> cartDetails = new ArrayList<>();
        Response<GetCartResponse> response = new Response<>();
        Body<GetCartResponse> body = new Body<>();
        GetCartResponse getCartResponse = new GetCartResponse();
        if(cart!=null){
            cart.getCartDetail().forEach( cartDetail -> {
                GetCartProductDetail getCartProductDetail = new GetCartProductDetail().builder()
                        .cartDetailId(cartDetail.getCartDetailId())
                        .price(cartDetail.getPrice())
                        .quantity(cartDetail.getQuantity())
                        .productId(cartDetail.getProductId())
                        .build();
                cartDetails.add(getCartProductDetail);
            });
            body.setData(getCartResponse.builder()
                    .cartDetail(cartDetails)
                    .cartId(cart.getCartId())
                    .addedOn(cart.getAddedOn())
                    .updatedOn(cart.getUpdatedOn())
                    .type(cart.getType())
                    .build());
        }
        Header header = new Header().builder()
                .status(1)
                .message("Success")
                .timeTaken(String.valueOf(appContext.timeTaken()))
                .messageCode("1")
                .build();
        response.setBody(body);
        response.setHeader(header);
        return response;
    }

    public Response<GetCartResponse> createFailureResponse(Exception $exp) {
        Response<GetCartResponse> response = new Response<>();
        Body<GetCartResponse> body = new Body<>();
        body.setData(null);
        Header header = new Header().builder()
                .status(0)
                .message($exp.getMessage())
                .timeTaken(String.valueOf(appContext.timeTaken()))
                .messageCode("0")
                .build();
        response.setBody(body);
        response.setHeader(header);
        return response;
    }

    public Response<GetCartResponse> createInternalErrorResponse(Exception $exp) {
        System.out.println($exp);
        Response<GetCartResponse> response = new Response<>();
        Body<GetCartResponse> body = new Body<>();
        body.setData(null);
        Header header = new Header().builder()
                .status(1)
                .message("Something went wrong")
                .timeTaken(String.valueOf(appContext.timeTaken()))
                .messageCode("0")
                .build();
        response.setBody(body);
        response.setHeader(header);
        return response;
    }
}
