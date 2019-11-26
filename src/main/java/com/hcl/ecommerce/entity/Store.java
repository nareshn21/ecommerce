package com.hcl.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="stores")
public class Store {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer storeId;
	 private Integer productId;
	 private String storeName;
	 private String storeLocation;
	 private double productDiscount;

	 

}
