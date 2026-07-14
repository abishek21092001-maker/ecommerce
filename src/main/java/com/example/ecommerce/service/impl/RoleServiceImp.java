package com.example.ecommerce.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.ecommerce.dto.RoleRequestDto;
import com.example.ecommerce.dto.RoleResponseDto;

public interface RoleServiceImp {

	RoleResponseDto addrole(RoleRequestDto rolereqeuestdto);

	Page<RoleResponseDto> getrole(int page, int size);

	RoleResponseDto getrolebyid(Long id);


	RoleResponseDto putrolebyid(Long id, RoleRequestDto rolerequestdto);

	String deletebyid(Long id);







}
