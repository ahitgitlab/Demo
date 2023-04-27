package com.example.dmj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dmj.model.Address;
import com.example.dmj.service.AddressService;

@RestController 
@RequestMapping("/api/v1/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping
	public ResponseEntity<String> create(@RequestBody Address address) {
		return new ResponseEntity<String>(addressService.create(address), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<String> updatEntity(@RequestBody Address address) {
		return new ResponseEntity<String>(addressService.update(address), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> DeleteEntity(@PathVariable("id") Long id) {
		return new ResponseEntity<String>(addressService.delete(id), HttpStatus.OK);
	}

	@PostMapping("/{id}")
	public ResponseEntity<List<Address>> getAddress(@PathVariable("id") Long addressId) {
		return new ResponseEntity<List<Address>>(addressService.getAddress(addressId), HttpStatus.OK);
	}
}
