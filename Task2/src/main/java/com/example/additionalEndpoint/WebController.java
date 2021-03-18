package com.example.additionalEndpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
	
	@RequestMapping("/greeting")
	public SampleResponse Sample() {
		SampleResponse response=new SampleResponse();
		response.setId(1);
		response.setContent("Hello, Fariha!");
		Adress adress=new Adress("24","25","Cumilla Sadar","Cumilla");
		response.setAdress(adress);
		List<String> teammembers= new ArrayList<String>();
		teammembers.add("Arafat");
		teammembers.add("Tanim");
		teammembers.add("Rizvi");
		response.setTeammembers(teammembers);
		return response;
	}

}
