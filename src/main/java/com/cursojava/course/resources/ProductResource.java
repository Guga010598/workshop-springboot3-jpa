package com.cursojava.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.course.entities.Product;
import com.cursojava.course.services.ProductService;


@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService service;
	
	@GetMapping // adicionando metodo para encontrar todos os usuarios
	public ResponseEntity<List<Product>> findAll () {
		
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	// metodo para retornar os usuarios por ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
