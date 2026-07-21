package com.example.ecommerce.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.UserRegisterRequestDTO;
import com.example.ecommerce.dto.UserResponseDTO;
import com.example.ecommerce.entity.Role;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.excepton.ResourceNotFoundException;
import com.example.ecommerce.repository.RoleRepository;
import com.example.ecommerce.repository.UserReository;
import com.example.ecommerce.service.impl.UserServiceImp;

@Service
public class UserService implements UserServiceImp {
	
	@Autowired
	private UserReository userrepository;
	
	@Autowired
	private RoleRepository rolerepository ;

	@Override
	public String registeruser(UserRegisterRequestDTO userregisterrequestDTO) {
		
		
		User user = new User();
		
		user.setName(userregisterrequestDTO.getName());
		user.setEmail(userregisterrequestDTO.getEmail());
		user.setAddress(userregisterrequestDTO.getAddress());
		user.setPhone(userregisterrequestDTO.getPhone());
		user.setPassword(userregisterrequestDTO.getPassword());
		user.setCreatedat(LocalDateTime.now());
		user.setUpdateddat(LocalDateTime.now());
		
		
		Role role = rolerepository.findById(userregisterrequestDTO.getRoleid()).orElseThrow(() -> new RuntimeException("Roleid is not found"));
		
		user.setRole(role);
		User saved = userrepository.save(user);
		
		String s = String.format("UR_" + "%03d", user.getUserid());
		user.setRolecode(s);
		
		 userrepository.save(saved);
		
		
		return "Sucessfully Created ";
	}

	@Override
	public Page<UserResponseDTO> getalluser(int page, int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<User> pages = userrepository.findAll(pageable);
		return pages.map(user ->{
			UserResponseDTO userresponsedto = new UserResponseDTO();
			userresponsedto.setUser_id(user.getUserid());
			
			userresponsedto.setName(user.getName());
			userresponsedto.setEmail(user.getEmail());
			userresponsedto.setAddress(user.getAddress());
			userresponsedto.setPassword(user.getPassword());
			userresponsedto.setPhone(user.getPhone());
			
			
			return userresponsedto;
		});
	}

	@Override
	public UserResponseDTO getuserbyid(Long id) {
		
		User user = userrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Id not found "));
		
		UserResponseDTO userresponsedto = new UserResponseDTO();
		
		userresponsedto.setUser_id(user.getUserid());
		userresponsedto.setName(user.getName());
		userresponsedto.setEmail(user.getEmail());
		userresponsedto.setAddress(user.getAddress());
		userresponsedto.setPassword(user.getPassword());
		userresponsedto.setPhone(user.getPhone());
		
		return userresponsedto;
	}

	@Override
	public String updateuserbyid(Long id, UserRegisterRequestDTO userregisterrequestDTO) {
		
		User user = userrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user id not found"));
		
		user.setName(userregisterrequestDTO.getName());
		user.setEmail(userregisterrequestDTO.getEmail());
		user.setAddress(userregisterrequestDTO.getAddress());
		user.setPhone(userregisterrequestDTO.getPhone());
		user.setPassword(userregisterrequestDTO.getPassword());
		
			
		user.setUpdateddat(LocalDateTime.now());
		
		
		
		userrepository.save(user);
		
		
		
		
		
		return "Sucessfully Updated";
	}

	@Override
	public String deleteuserbyid(Long id) {
		User user = userrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found"));
		
		userrepository.delete(user);
		
		return "deleted sucessfully";
	}
	
	


}
