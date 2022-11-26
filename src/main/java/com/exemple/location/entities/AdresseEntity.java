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
@Table(name = "adresse")
@Inheritance(strategy = InheritanceType.JOINED)
public class AdresseEntity extends MyEntity implements  Serializable{
	public AdresseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdresseEntity(Long id, String ville, String rue, int no, int cp, String departement) {
		super();
		this.id = id;
		this.ville = ville;
		this.rue = rue;
		this.no = no;
		this.cp = cp;
		this.departement = departement;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ville;
	private String rue;
	private int no;
	private int cp;
	private String departement;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}

}
