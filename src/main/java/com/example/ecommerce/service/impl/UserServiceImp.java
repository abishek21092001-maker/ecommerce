package com.example.ecommerce.service.impl;

import org.springframework.data.domain.Page;

import com.example.ecommerce.dto.UserRegisterRequestDTO;
import com.example.ecommerce.dto.UserResponseDTO;

public interface UserServiceImp {

	String registeruser(UserRegisterRequestDTO userregisterrequestDTO);

	Page<UserResponseDTO> getalluser(int page, int size);

	UserResponseDTO getuserbyid(Long id);

	String updateuserbyid(Long id, UserRegisterRequestDTO userregisterrequestDTO);

	String deleteuserbyid(Long id);



}
