package com.example.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entity.RefershTokenEntity;
import com.example.ecommerce.entity.Userentity;

public interface RefershTokenRepository extends JpaRepository<RefershTokenEntity,Long> {
	
	Optional <RefershTokenEntity> findByrefershtoken(String refershtoken) ;
	void deleteByuser(Userentity user);
	
	Optional<RefershTokenEntity> findByuser(Userentity user);
	
	

}
