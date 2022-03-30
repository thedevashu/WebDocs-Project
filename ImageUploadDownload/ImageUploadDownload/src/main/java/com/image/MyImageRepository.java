package com.image;
import org.springframework.data.jpa.repository.JpaRepository;

import com.image.pojo.Image;

public interface MyImageRepository extends JpaRepository<Image,Integer>{

	public Image findByName(String name);
	
}
