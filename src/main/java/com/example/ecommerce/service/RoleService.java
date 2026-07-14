package com.example.ecommerce.service;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.RoleRequestDto;
import com.example.ecommerce.dto.RoleResponseDto;
import com.example.ecommerce.entity.Role;
import com.example.ecommerce.repository.RoleRepository;
import com.example.ecommerce.service.impl.RoleServiceImp;

@Service
public class RoleService implements RoleServiceImp{
	
	@Autowired
	public RoleRepository rolerepository;
	
	@Override
	public RoleResponseDto addrole(RoleRequestDto rolereqeuestdto) {
		
		Role role = new Role();
		
		role.setName(rolereqeuestdto.getName());
		role.setDescription(rolereqeuestdto.getDescription());
		role.setCreatedat(LocalDateTime.now());
		role.setUpdatedat(LocalDateTime.now());
		
		Role savedrole = rolerepository.save(role);
		
		String saved = "RE_" + String.format("%03d",role.getRoleid() ) ;
		savedrole.setRolecode(saved);
		
		savedrole = rolerepository.save(savedrole);
		
		
		RoleResponseDto roleresponsedto = new RoleResponseDto();
		
		roleresponsedto.setRoleid(savedrole.getRoleid());
		roleresponsedto.setRolecode(saved);
		roleresponsedto.setName(savedrole.getName());
		roleresponsedto.setDescription(savedrole.getDescription());
		roleresponsedto.setCreatedat(savedrole.getCreatedat());
		
		
		return roleresponsedto;
	}

	@Override
	public Page<RoleResponseDto> getrole(int page, int size) {
		
		 Pageable pageable = PageRequest.of(page, size);
		 
		 Page<Role> pagerole = rolerepository.findAll(pageable);
		 
		 return pagerole.map(role ->{
		
		
		RoleResponseDto roleresponsedto = new RoleResponseDto();
		roleresponsedto.setRoleid(role.getRoleid());
		roleresponsedto.setName(role.getName());
		roleresponsedto.setDescription(role.getDescription());
		roleresponsedto.setRolecode(role.getRolecode());
		roleresponsedto.setCreatedat(role.getCreatedat());
		
		return roleresponsedto;
		
 
		
		 });
		 
		 
		
	
	}

	@Override
	public RoleResponseDto getrolebyid(Long roleid) {
		
		Role role = rolerepository.findById(roleid).orElseThrow(() -> new RuntimeException("No Roles Found"));
		RoleResponseDto roleresponsedto = new RoleResponseDto();
		roleresponsedto.setRoleid(role.getRoleid());
		roleresponsedto.setRolecode(role.getRolecode());
		roleresponsedto.setName(role.getName());
		roleresponsedto.setDescription(role.getDescription());
		roleresponsedto.setCreatedat(role.getCreatedat());
		
		return roleresponsedto;
	}

	@Override
	public RoleResponseDto putrolebyid(Long id, RoleRequestDto rolerequestdto) {
		
		Role role = rolerepository.findById(id).orElseThrow(() -> new RuntimeException("No Roles Found"));
		
		role.setName(rolerequestdto.getName());
		role.setDescription(rolerequestdto.getDescription());
		role.setUpdatedat(LocalDateTime.now());
		
		
		Role update = rolerepository.save(role);
		
		RoleResponseDto roleresponsedto = new RoleResponseDto();
		
		roleresponsedto.setRoleid(update.getRoleid());
	    roleresponsedto.setRolecode(update.getRolecode());
	    roleresponsedto.setName(update.getName());
	    roleresponsedto.setDescription(update.getDescription());
	    roleresponsedto.setCreatedat(update.getCreatedat());
	    roleresponsedto.setUpdatedat(update.getUpdatedat());
		return roleresponsedto;
	}

	@Override
	public String deletebyid(Long id) {
		
		Role role = rolerepository.findById(id).orElseThrow(() -> new RuntimeException("No Roles to find to be Deleted"));
		
		rolerepository.delete(role);
		
		return "Deleted Sucessfully";
	}



	

}
