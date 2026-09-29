package com.example.ecommerce.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.CartRequestDto;
import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.Userentity;
import com.example.ecommerce.repository.CartItemRepository;
import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserReository;
import com.example.ecommerce.service.impl.CartServiceImp;

import jakarta.transaction.Transactional;
@Service
public class CartService implements CartServiceImp{
	
	@Autowired
	private ProductRepository productrepo;
	
	@Autowired
	private CartRepository cartrepo;
	
	@Autowired
	private UserReository uspero;
	
	@Autowired
	private CartItemRepository cartitems;

	@Override
	@Transactional
	public CartRequestDto addcart(CartRequestDto cartrequestdto) {
		

		Long id = cartrequestdto.getProductid();
		Authentication  authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		Userentity user = uspero.findByEmail(email).orElseThrow(() -> new RuntimeException("Email not found"));
		Cart cart = cartrepo.findByuser(user).orElseThrow(() -> new RuntimeException("User not found"));
		Product pro = productrepo.findById(id).orElseThrow(() -> new RuntimeException("product not found"));
        CartItem item = new CartItem();
		item.setProduct(pro);
		item.setPrice(pro.getPrice());
		item.setCart(cart);
		BigDecimal subtotal = pro.getPrice().multiply(cartrequestdto.getQuantity());
		item.setSubtotal(subtotal);
		item.setQuantity(cartrequestdto.getQuantity());
		cartitems.save(item);

		
		BigDecimal total = cart.getCartitem()
		        .stream()
		        .map(CartItem::getSubtotal)
		        .reduce(BigDecimal.ZERO, BigDecimal::add);

		cart.setTotal(total);

		cartrepo.save(cart);
		
		return cartrequestdto;
	}
	


}
