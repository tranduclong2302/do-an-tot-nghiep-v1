package com.vuhien.application.service;


import com.vuhien.application.entity.Product;
import com.vuhien.application.entity.ShoppingCart;
import com.vuhien.application.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface ShoppingCartService {
    ShoppingCart addItemToCart(Product product, Long quantity, User buyer);

    ShoppingCart updateItemInCart(Product product, Long quantity, User buyer);

    ShoppingCart deleteItemFromCart(Product product, User buyer);

}