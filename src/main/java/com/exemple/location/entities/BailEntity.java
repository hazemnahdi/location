package com.exemple.location.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "bail")
@Inheritance(strategy = InheritanceType.JOINED)
public class BailEntity extends MyEntity implements  Serializable {
	
	public BailEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BailEntity(Long id, int no, float loyerTCC, Date date_debut, Date durée) {
		super();
		this.id = id;
		this.no = no;
		this.loyerTCC = loyerTCC;
		this.date_debut = date_debut;
		this.durée = durée;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int no;
	private float loyerTCC;
	private Date date_debut;
	private Date durée;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public float getLoyerTCC() {
		return loyerTCC;
	}
	public void setLoyerTCC(float loyerTCC) {
		this.loyerTCC = loyerTCC;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDurée() {
		return durée;
	}
	public void setDurée(Date durée) {
		this.durée = durée;
	}
	
}
