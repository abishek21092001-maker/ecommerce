package com.example.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.entity.Product;

public interface CartItemRepository extends JpaRepository<CartItem,Long>{
	
	Optional<CartItem> findByProductAndCart(Product product, Cart cart);

}
