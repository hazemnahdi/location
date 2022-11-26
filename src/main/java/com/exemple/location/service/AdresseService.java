package com.exemple.location.service;

import java.util.List;

import com.exemple.location.dto.AdresseDTO;

public interface AdresseService {
      public List<AdresseDTO> findAllAdresses();
	
	  public void addAdresse (AdresseDTO adresse);
}
