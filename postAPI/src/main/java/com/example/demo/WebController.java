package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
	
	@RequestMapping(value="/test",method=RequestMethod.POST)
	public PostResponse Test(@RequestBody PostRequest inputPayload) {
		PostResponse response=new PostResponse();
		response.setId(inputPayload.getId()*100);
		response.setMessage("Hello "+inputPayload.getName());
		response.setExtra("Extra message.");
		return response;
	}
	
}
