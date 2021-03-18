package com.example.additionalEndpoint;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
	
	@RequestMapping("/v1/greeting/{name}")
	public SampleResponse Sample(@PathVariable("name") String name)
	{
		SampleResponse response=new SampleResponse();
		response.setId(1);
		response.setMessage("Hello, "+name);
		return response;
	}

}
