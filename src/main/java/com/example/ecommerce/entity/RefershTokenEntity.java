package com.example.ecommerce.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="RefershToken")
public class RefershTokenEntity {


	public RefershTokenEntity() {
		super();
	}

	public RefershTokenEntity(Long generateid, String refershtoken, LocalDateTime expirydate, LocalDateTime createddate,
			Userentity user) {
		super();
		this.generateid = generateid;
		this.refershtoken = refershtoken;
		this.expirydate = expirydate;
		this.createddate = createddate;
		this.user = user;
	}

	public Long getGenerateid() {
		return generateid;
	}

	public void setGenerateid(Long generateid) {
		this.generateid = generateid;
	}

	public String getRefershtoken() {
		return refershtoken;
	}

	public void setRefershtoken(String refershtoken) {
		this.refershtoken = refershtoken;
	}

	public LocalDateTime getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(LocalDateTime expirydate) {
		this.expirydate = expirydate;
	}

	public LocalDateTime getCreateddate() {
		return createddate;
	}

	public void setCreateddate(LocalDateTime createddate) {
		this.createddate = createddate;
	}

	public Userentity getUser() {
		return user;
	}

	public void setUser(Userentity user) {
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long generateid;
	
	@Column(nullable = false,unique = true)
	private String refershtoken;
	
	@Column(nullable = false)
	private LocalDateTime expirydate;
	
	@CreatedDate
	private LocalDateTime createddate;
	
	@OneToOne(fetch = FetchType.EAGER)	
    @JoinColumn(name = "user_id",nullable = false)
	private Userentity user;
	

}
