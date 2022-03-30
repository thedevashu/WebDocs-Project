package com.image.dao;

import java.sql.Blob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.image.MyImageRepository;
import com.image.pojo.Image;


@Repository
public class ImageDao {

	@Autowired
	MyImageRepository repo;
	
	public Image showImage(String name) {

		Image image = repo.findByName(name);
		
		return image;
	}
	
	public void addImage(String name, Blob image)
	{
		Image i = new Image(name,image);
		
		repo.save(i);
	}
}
