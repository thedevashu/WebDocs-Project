package com.image.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.image.dao.ImageDao;
import com.image.pojo.Image;


@Controller
public class ImageController {


	@Autowired
	ImageDao dao;

	@RequestMapping("/index")
	public String showIndex() {

		return "index";
	}

	@RequestMapping("/home")
	public String showHome() {

		return "home";
	}
	
	@PostMapping("/getImage")
	public String verifyUser(Model model,@RequestParam String name) {

		Image result = dao.showImage(name);
		
		if(result != null) {

			model.addAttribute("image", result);
			return "home";
		}
		else {

			model.addAttribute("errormsg", "No image found !!");
			return "home";
		}
	}

	@PostMapping("/addImage")
	public String addProduct(@RequestParam String name,@RequestParam("file") MultipartFile file){
		
		byte[] byteArr;
		Blob blob;
		try {
			byteArr = file.getBytes();
			blob = new SerialBlob(byteArr);
			dao.addImage(name,blob);
			
			return "index";
		} catch (SQLException e) {

			e.printStackTrace();
			return "index";
		}
		catch (IOException e1) {

			e1.printStackTrace();
			return "index";
		}



	}

}
