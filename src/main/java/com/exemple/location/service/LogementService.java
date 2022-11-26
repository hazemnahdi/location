package com.exemple.location.service;

import java.util.List;

import com.exemple.location.dto.LogementDTO;

public interface LogementService {
public List<LogementDTO> findAllLogements();
	
	public void addLogement (LogementDTO logement);

}
