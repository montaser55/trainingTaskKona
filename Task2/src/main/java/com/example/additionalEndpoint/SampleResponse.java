package com.example.additionalEndpoint;

import java.util.List;

public class SampleResponse {
	
	private long id;
	private String content;
	private Adress adress;
	private List<String> teammembers;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	public List<String> getTeammembers() {
		return teammembers;
	}
	public void setTeammembers(List<String> teammembers) {
		this.teammembers = teammembers;
	}
	
	
}
