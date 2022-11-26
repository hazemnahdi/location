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

import com.exemple.location.dto.BailDTO;
import com.exemple.location.service.BailService;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class BailController {
	@Autowired
	private BailService bailService;
	@GetMapping("/bails")
	public ResponseEntity<List<BailDTO>> getAllBails() {
		return ResponseEntity.ok(bailService.findAllBails());
	}
	/*
	 * method to add user 
	 */
	@PostMapping("/bail")
    public ResponseEntity<BailDTO> create(@RequestBody BailDTO bailDTO) {
    	bailService.addBail(bailDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(bailDTO);
    }

}
