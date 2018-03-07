package com.vikram.pcf.easy_test.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EasyTestRestTemplate {

	public Object getRestResponseFor(String url,Class<?> clazz) {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = Configuration.BASE_URL+url;
		ResponseEntity<?> response=  restTemplate.getForEntity(fooResourceUrl, clazz);
		return response.getBody();
	}
}
