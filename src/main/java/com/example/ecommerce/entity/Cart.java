package com.example.ecommerce.entity;

import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {
	
	@Override
	public String toString() {
		return "Cart []";
	}

	public Cart(Long cartid, User user, List<CartItem> cartitem, Long total, String createdat, String updatedat) {
		super();
		this.cartid = cartid;
		this.user = user;
		this.cartitem = cartitem;
		this.total = total;
		this.createdat = createdat;
		this.updatedat = updatedat;
	}

	public Long getCartid() {
		return cartid;
	}

	public void setCartid(Long cartid) {
		this.cartid = cartid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CartItem> getCartitem() {
		return cartitem;
	}

	public void setCartitem(List<CartItem> cartitem) {
		this.cartitem = cartitem;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getCreatedat() {
		return createdat;
	}

	public void setCreatedat(String createdat) {
		this.createdat = createdat;
	}

	public String getUpdatedat() {
		return updatedat;
	}

	public void setUpdatedat(String updatedat) {
		this.updatedat = updatedat;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cartid;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "Cart",cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_item_id")
	private List<CartItem> cartitem;
	
	@Column(name = "total_amount",precision = 10 ,scale = 2)
	private Long total;
	
	@CreatedDate
	@Column(name = "created_at")
	private String createdat;
	
	@LastModifiedDate
	@Column(name = "updated_at")
	private String updatedat;
	
	
	
	
	
	
	
	
	

}
