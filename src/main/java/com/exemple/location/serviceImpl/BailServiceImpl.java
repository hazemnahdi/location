package com.exemple.location.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.location.dto.BailDTO;
import com.exemple.location.entities.BailEntity;
import com.exemple.location.helper.ModelMapperConverter;
import com.exemple.location.repository.BailRepository;
import com.exemple.location.service.BailService;
@Service
@Transactional
public class BailServiceImpl implements BailService{
	@Autowired
	private BailRepository bailRepository;
	@Autowired
	private ModelMapperConverter modelMapperConverter;
	@Override
	public List<BailDTO> findAllBails() {
		// TODO Auto-generated method stub
		return modelMapperConverter.convertAllToDTO(bailRepository.findAll(), BailDTO.class);
	}

	@Override
	public void addBail(BailDTO bail) {
		// TODO Auto-generated method stub
		bailRepository.save(modelMapperConverter.converToEntity(bail, BailEntity.class));
		
	}

}
