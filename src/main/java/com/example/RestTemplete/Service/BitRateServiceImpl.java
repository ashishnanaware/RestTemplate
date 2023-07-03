package com.example.RestTemplete.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.RestTemplete.BO.BitRate;
import com.example.RestTemplete.repository.BitRepository;

@Service
public class BitRateServiceImpl implements BitRateService{

	@Autowired
	private BitRepository bitRepository; 
	@Override
	public List<BitRate> consumeApi() {
		RestTemplate template = new RestTemplate();
		ResponseEntity<List<BitRate>> response = template.exchange("https://bitpay.com/api/rates", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<BitRate>>() {
				});		
		return bitRepository.saveAll(response.getBody());
	}
	@Override
	public List<BitRate> convertToPdf() {
		
		return bitRepository.allData();
	}
}
