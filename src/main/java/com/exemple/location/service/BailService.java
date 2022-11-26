package com.exemple.location.service;

import java.util.List;

import com.exemple.location.dto.BailDTO;

public interface BailService {
   public List<BailDTO> findAllBails();
	
	public void addBail (BailDTO bail);

}
