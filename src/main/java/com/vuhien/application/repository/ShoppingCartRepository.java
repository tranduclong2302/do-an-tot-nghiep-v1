package com.vuhien.application.repository;

import com.vuhien.application.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository  extends JpaRepository<ShoppingCart, Long> {
}
