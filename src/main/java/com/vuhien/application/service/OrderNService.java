package com.vuhien.application.service;

import com.vuhien.application.entity.ShoppingCart;
import org.springframework.stereotype.Service;

@Service
public interface OrderNService {
    void saveOrder(ShoppingCart cart);
}
