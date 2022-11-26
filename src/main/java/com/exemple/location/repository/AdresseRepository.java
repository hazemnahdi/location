package com.exemple.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.location.entities.AdresseEntity;


public interface AdresseRepository extends JpaRepository<AdresseEntity, Long> {

}
