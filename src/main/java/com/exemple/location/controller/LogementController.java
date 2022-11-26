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
import com.exemple.location.dto.LogementDTO;
import com.exemple.location.service.AdresseService;
import com.exemple.location.service.LogementService;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class LogementController {
	@Autowired
	private LogementService logementService;
	@GetMapping("/logements")
	public ResponseEntity<List<LogementDTO>> getAllLogements() {
		return ResponseEntity.ok(logementService.findAllLogements());
	}
	/*
	 * method to add user 
	 */
	@PostMapping("/logement")
    public ResponseEntity<LogementDTO> create(@RequestBody LogementDTO logementDTO) {
    	logementService.addLogement(logementDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(logementDTO);
    }

}
