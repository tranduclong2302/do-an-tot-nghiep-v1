package com.vuhien.application.repository;

import com.vuhien.application.entity.CartItem;
import com.vuhien.application.entity.Product;
import com.vuhien.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByBuyer(User user);

    CartItem findByBuyerAndProduct(User user, Product product);
}
