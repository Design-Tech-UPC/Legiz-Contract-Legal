package com.designtech.legalcontract.Contract.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.designtech.legalcontract.Contract.domain.model.ContractLegal;
import com.designtech.legalcontract.Contract.domain.service.ContractLegalService;
import com.designtech.legalcontract.External.domain.model.Client;
import com.designtech.legalcontract.External.domain.model.Lawyer;

@Service
public class ContractLegalServiceImpl implements ContractLegalService {

	private final RestTemplate restTemplate;

	@Value("${lawyerApi}")
	private String lawyerApi;
	@Value("${clientApi}")
	private String clientApi;

	@Autowired
	public ContractLegalServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public ContractLegal createContratLegal(Long clientId, Long laywerId, ContractLegal contractLegal) {

		Client client = restTemplate.getForObject(clientApi, Client.class);
		Lawyer lawyer = restTemplate.getForObject(lawyerApi, Lawyer.class);



		contractLegal = new ContractLegal();
		contractLegal.setClientId(clientId); //TODO, VALIDATE CLIENT ID WITH CLIENT OBJECT
		contractLegal.setLawyerId(laywerId); //TODO, VALIDATE LAWYER ID WITH LAWYER OBJECT

		return contractLegal;
	}

	@Override
	public ContractLegal updateContratLegal(Long clientId, Long laywerId, Long contratLegalId,
			ContractLegal contratLegalRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deleteContratLegal(Long clientId, Long laywerId, Long contratLegalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ContractLegal> getAllContratLegalByClientId(Long clientId, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ContractLegal> getAllContratLegalByLawyerId(Long laywerId, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ContractLegal> getAllContratLegalByClientIdAndLawyerId(Long clientId, Long laywerId,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ContractLegal> getAllContratLegal(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
