package com.hcl.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@NoArgsConstructor

@Setter
@Entity
@Table(name="users_review")
public class UserReview {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer userReviewId;
	 private Integer storeId;
	 private Integer review;
	 
}
