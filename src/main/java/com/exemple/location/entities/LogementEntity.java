package com.exemple.location.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
@Entity
@Table(name = "logement")
@Inheritance(strategy = InheritanceType.JOINED)
public class LogementEntity extends MyEntity implements  Serializable{
	public LogementEntity(Long id, int ref, int nbpiéces, float surface, String photo, String loyer, float charges,
			float partAgence) {
		super();
		this.id = id;
		this.ref = ref;
		this.nbpiéces = nbpiéces;
		this.surface = surface;
		this.photo = photo;
		this.loyer = loyer;
		this.charges = charges;
		this.partAgence = partAgence;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int ref;
    private int nbpiéces;
    private float surface;
    private String photo;
    private String loyer;
    private float charges;
    private float partAgence;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getNbpiéces() {
		return nbpiéces;
	}
	public void setNbpiéces(int nbpiéces) {
		this.nbpiéces = nbpiéces;
	}
	public float getSurface() {
		return surface;
	}
	public void setSurface(float surface) {
		this.surface = surface;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getLoyer() {
		return loyer;
	}
	public void setLoyer(String loyer) {
		this.loyer = loyer;
	}
	public float getCharges() {
		return charges;
	}
	public void setCharges(float charges) {
		this.charges = charges;
	}
	public float getPartAgence() {
		return partAgence;
	}
	public void setPartAgence(float partAgence) {
		this.partAgence = partAgence;
	}
	
}
