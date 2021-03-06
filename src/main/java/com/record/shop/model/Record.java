package com.record.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Record {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	String artist;
	
	@Column(name = "RECORD_NAME")
	String name;
	
	@Column(name = "RECORD_DESC")
	String description;
	
	String genre;
	
	@Column(name = "RECORD_CONDITION")
	String condition;
	
	Double price;
	
	@Column(name = "RELEASE_YEAR")
	Integer year;
	
	String cover;

	public Record() { }

	public Record(Long id, String artist, String name, String description, String genre, String condition, Double price,
			Integer year, String cover) {
		super();
		this.id = id;
		this.artist = artist;
		this.name = name;
		this.description = description;
		this.genre = genre;
		this.condition = condition;
		this.price = price;
		this.year = year;
		this.cover = cover;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}

	@Override
	public String toString() {
		return name + " of " + artist;
	}
}
