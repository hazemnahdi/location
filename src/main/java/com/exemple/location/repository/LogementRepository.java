package com.exemple.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.exemple.location.entities.LogementEntity;

public interface LogementRepository extends JpaRepository<LogementEntity, Long> {
	

}
