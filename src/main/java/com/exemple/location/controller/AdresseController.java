package com.exemple.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.location.dto.AdresseDTO;
import com.exemple.location.service.AdresseService;


@CrossOrigin()
@RestController
@RequestMapping("/api")
public class AdresseController {
	@Autowired
	private AdresseService adresseService;
	@GetMapping("/adresses")
	public ResponseEntity<List<AdresseDTO>> getAllAdresses() {
		return ResponseEntity.ok(adresseService.findAllAdresses());
	}
	/*
	 * method to add user 
	 */
	@PostMapping("/adresse")
    public ResponseEntity<AdresseDTO> create(@RequestBody AdresseDTO adresseDTO) {
    	adresseService.addAdresse(adresseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(adresseDTO);
    }
}
