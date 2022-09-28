package com.designtech.legalcontract.Contract.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ContractLegalServiceImpl{
	
	private final RestTemplate restTemplate;
	
	@Value("${lawyerApi}")
	private String lawyerApi;
	@Value("${clientApi}")
	private String clientApi;
	
	@Autowired
	public ContractLegalServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	//TODO SERVICES IMPLEMENTATION
}
