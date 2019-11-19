package com.bonvoyage.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
public class Phone {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private Long id;
	
	@Column(name="Area")
	@NotNull(message="{NotNull}")
	@Range(min=100,max=999,message="{Digits.three}")
	private int area;
	
	@Column(name="{Prefix}")
	@NotNull(message="{NotNull}")
	@Range(min=100,max=999,message="{Digits.three}")
	private int prefix;
	
	@Column(name="Number")
	@NotNull(message="{NotNull}")
	@Range(min=1000,max=9999,message="{Digits.four}")
	private int number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getPrefix() {
		return prefix;
	}

	public void setPrefix(int prefix) {
		this.prefix = prefix;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
