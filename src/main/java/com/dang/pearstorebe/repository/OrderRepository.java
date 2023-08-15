package com.dang.pearstorebe.repository;

import com.dang.pearstorebe.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
public interface OrderRepository extends JpaRepository<Order, UUID> {
 List<Order> findByAccountId(String sessionId);
}
