package com.exemple.location.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.location.dto.AdresseDTO;
import com.exemple.location.dto.LogementDTO;
import com.exemple.location.entities.BailEntity;
import com.exemple.location.entities.LogementEntity;
import com.exemple.location.helper.ModelMapperConverter;
import com.exemple.location.repository.BailRepository;
import com.exemple.location.repository.LogementRepository;
import com.exemple.location.service.LogementService;

@Service
@Transactional
public class LogementServiceImpl implements LogementService {
	@Autowired
	private LogementRepository logementRepository;
	@Autowired
	private ModelMapperConverter modelMapperConverter;
	@Override
	public List<LogementDTO> findAllLogements() {
		// TODO Auto-generated method stub
		return modelMapperConverter.convertAllToDTO(logementRepository.findAll(), LogementDTO.class);
	}

	@Override
	public void addLogement(LogementDTO logement) {
		// TODO Auto-generated method stub
		logementRepository.save(modelMapperConverter.converToEntity(logement, LogementEntity.class));
		
	}

}
