package com.hcl.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
Optional<Store> findByStoreName(String storeName);
List<Store> findByProductId(Integer productId);
}
