package com.exemple.location.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.location.dto.AdresseDTO;
import com.exemple.location.entities.AdresseEntity;
import com.exemple.location.helper.ModelMapperConverter;
import com.exemple.location.repository.AdresseRepository;
import com.exemple.location.service.AdresseService;

@Service
@Transactional
public class AdresseServiceImpl implements AdresseService {
	@Autowired
	private AdresseRepository adresseRepository;
	@Autowired
	private ModelMapperConverter modelMapperConverter;
	@Override
	public List<AdresseDTO> findAllAdresses() {
		// TODO Auto-generated method stub
		return modelMapperConverter.convertAllToDTO(adresseRepository.findAll(), AdresseDTO.class);
	}

	@Override
	public void addAdresse(AdresseDTO adresse) {
		// TODO Auto-generated method stub
		adresseRepository.save(modelMapperConverter.converToEntity(adresse, AdresseEntity.class));
		
	}

}
