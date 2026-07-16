package com.example.ecommerce.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.dto.ProductRequestDto;
import com.example.ecommerce.dto.ProductResponseDto;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.impl.ProductServiceImp;
@Service
public class ProductService implements ProductServiceImp {
	@Autowired
	private ProductRepository productrepository;
	
	@Autowired
	private CategoryRepository categoryrepository ;

	// note :this topic i have to study again
	@Override
	public String addproduct(ProductRequestDto productrequestdto,
	                         MultipartFile image) throws IOException {

	    // Create Product object
	    Product product = new Product();

	    // Set Product details
	    product.setName(productrequestdto.getName());
	    product.setDescription(productrequestdto.getDescription());
	    product.setPrice(productrequestdto.getPrice());
	    product.setStock(productrequestdto.getStock());
	    product.setCreatedat(LocalDateTime.now());
	    product.setUpdatedat(LocalDateTime.now());

	    // Find Category by ID
	    Category category = categoryrepository
	            .findById(productrequestdto.getCategoryid())
	            .orElseThrow(() -> new RuntimeException("Category Not Found"));

	    // Set Category
	    product.setCategoryid(category);

	    // Get uploaded file name
	    String filename = image.getOriginalFilename();

	    // Create uploads folder if it does not exist
	    Path uploadPath = Paths.get("uploads");

	    if (!Files.exists(uploadPath)) {
	        Files.createDirectories(uploadPath);
	    }

	    // Save image into uploads folder
	    Files.copy(
	            image.getInputStream(),
	            uploadPath.resolve(filename),	
	            StandardCopyOption.REPLACE_EXISTING);

	    // Save image path in database
	    product.setImageurl("uploads/" + filename);

	    // Save product first to generate Product ID
	    Product saved = productrepository.save(product);

	    // Generate Product Code
	    String code = String.format("P_%03d", saved.getProductid());

	    // Set Product Code
	    saved.setProductcode(code);

	    // Save again to update Product Code
	    productrepository.save(saved);

	    return "Product Saved Successfully";
	}

	@Override
	public Page<ProductResponseDto> getproduct(int page, int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Product> products = productrepository.findAll(pageable);
		return products.map(product ->{
			ProductResponseDto productresponsedto = new ProductResponseDto();
			productresponsedto.setName(product.getName());
			productresponsedto.setDescription(product.getDescription());
			productresponsedto.setPrice(product.getPrice());
			productresponsedto.setStock(product.getStock());
			productresponsedto.setImageurl(product.getImageurl());
			
			return productresponsedto;	
		});
		
	
		
		
	}

	

	

	

}
