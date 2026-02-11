package com.example.demo.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

import Exceptionnotfound.exceptionnotfound;


@RestController
@RequestMapping("/api/v1/")

public class ItemController {
	@Autowired
	private ItemRepository Repository;
	@PostMapping("/Item")
	public Item createItem (@RequestBody Item item) {
		return Repository.save(item);
	}
	@GetMapping("/Item")
	public List<Item> getAllItems(){

			return Repository.findAll();
		
	}
	@GetMapping("/Item/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable Long id) {
		Item item = Repository.findById(id)
				.orElseThrow(() -> new exceptionnotfound("Item not exist with id :" + id));
		return ResponseEntity.ok(item);
	}
	
	
	
	@PutMapping("/item/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item itemDetails){
		Item item = Repository.findById(id)
				.orElseThrow(() -> new exceptionnotfound("Item not exist with id :" + id));	
		item.setItemname(itemDetails.getItemname());
		item.setPrice(itemDetails.getPrice());
		item.setManufacturingDate(itemDetails.getManufacturingDate());
		
		Item updatedItem = Repository.save(item);
		return ResponseEntity.ok(updatedItem);
	}
	@DeleteMapping("/Item/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Long id){
		Item item = Repository.findById(id)
				.orElseThrow(() -> new exceptionnotfound("Item not exist with id :" + id));
		
		Repository.delete(item);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}

	
	