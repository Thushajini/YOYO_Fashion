package com.example.eCommerce.dto;

import lombok.Data;

@Data
public class AddToCartDto {
    private Long productId;
    private int Quantity;
}
