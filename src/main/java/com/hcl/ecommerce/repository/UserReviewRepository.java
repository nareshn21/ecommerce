package com.hcl.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.entity.UserReview;
@Repository
public interface UserReviewRepository extends JpaRepository<UserReview, Integer> {
	
	Optional<UserReview> findByStoreId(Integer storeId);

}
