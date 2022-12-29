package com.vuhien.application.repository;

import com.vuhien.application.entity.OrderDetailN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailN, Long> {
}
