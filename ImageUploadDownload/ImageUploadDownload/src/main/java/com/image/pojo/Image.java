package com.image.pojo;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="image_tbl")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="image_id")
	private int imageId;
	
	@Column(name="name",columnDefinition = "VARCHAR(100)",nullable = false,unique = true)
	private String name;
	
	@Column(name="image_data",columnDefinition = "MEDIUMBLOB")
	@Lob
	private Blob image;

	public int getId() {
		return imageId;
	}

	public void setId(int id) {
		this.imageId = id;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob profilePhoto) {
		this.image = profilePhoto;
	}

	public Image()
	{
		
	}
	
	public Image(String name,Blob image) {
		
		this.name = name;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Image [id=" + imageId + ", profilePhoto=" + image + "]";
	}
	
	
	
}
