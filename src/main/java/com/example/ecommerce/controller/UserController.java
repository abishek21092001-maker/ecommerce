package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.UserRegisterRequestDTO;
import com.example.ecommerce.dto.UserResponseDTO;
import com.example.ecommerce.service.impl.UserServiceImp;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserServiceImp uerserviceimp;
	
	
	@PostMapping
	public String registeruser(@RequestBody UserRegisterRequestDTO userregisterrequestDTO ) {
		
		return uerserviceimp.registeruser(userregisterrequestDTO);
	}
	
	
	@GetMapping
	public Page<UserResponseDTO> getalluser(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size) {
		return uerserviceimp.getalluser(page,size);
		
	}
	
	@GetMapping("/{id}")
	public UserResponseDTO getuserbyid(@PathVariable Long id) {
		return uerserviceimp.getuserbyid(id);
	}
	
	@PutMapping("/{id}")
	public String updateuserbyid(@PathVariable Long id , @RequestBody UserRegisterRequestDTO userregisterrequestDTO) {
		return uerserviceimp.updateuserbyid(id,userregisterrequestDTO);
	}
	
	@DeleteMapping("/{id}")
	public String deleteuserbyid(@PathVariable Long id) {
		return uerserviceimp.deleteuserbyid(id);
	}
	
	
	

}
