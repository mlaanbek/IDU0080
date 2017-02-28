package com.idu0080.servicesImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.idu0080.entities.WashInput;
import com.idu0080.services.RESTWashInputService;

@Service
public class RESTWashInputServiceImpl implements RESTWashInputService {
	
	public List<WashInput> getAllWashInputs() {
		
		WashInput[] inputs_array = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			inputs_array = restTemplate.getForObject("http://localhost:8080/CarWash_REST_service/service/washinputs", WashInput[].class);
		} catch (Exception e) {
			
		}
		List<WashInput> input_list = Arrays.asList(inputs_array);
		return input_list;
	}

}
