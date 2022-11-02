package com.designtech.legalcontract.Contract.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.designtech.legalcontract.External.services.LegizClient;
import com.designtech.legalcontract.External.services.LegizLawyer;
import com.designtech.legalcontract.Contract.domain.model.ContractLegal;
import com.designtech.legalcontract.Contract.domain.repository.ContractLegalRepository;
import com.designtech.legalcontract.Contract.domain.service.ContractLegalService;
import com.designtech.legalcontract.External.domain.model.Client;
import com.designtech.legalcontract.External.domain.model.Lawyer;
import com.designtech.legalcontract.exception.ResourceNotFoundException;

@Service
public class ContractLegalServiceImpl implements ContractLegalService {

	private final LegizClient legizClient;

	private final LegizLawyer legizLawyer;

	private final ContractLegalRepository contractLegalRepository;
	
	@Autowired
	public ContractLegalServiceImpl(LegizClient legizClient,LegizLawyer legizLawyer, ContractLegalRepository contractLegalRepository) {
		this.legizClient = legizClient;
		this.legizLawyer = legizLawyer;
		this.contractLegalRepository = contractLegalRepository;
	}

	@Override
	public ContractLegal createContractLegal(Long clientId, Long lawyerId, ContractLegal contractLegal) {
		if(!legizClient.existById(clientId))
			 throw new ResourceNotFoundException("Client","Id",clientId);
		
		if(!legizLawyer.existById(lawyerId))
			 throw new ResourceNotFoundException("Lawyer","Id",lawyerId);
		contractLegal.setClientId(clientId);
		contractLegal.setLawyerId(lawyerId);		
		return contractLegalRepository.save(contractLegal);
	}

	@Override
	public ContractLegal updateContractLegal(Long clientId, Long laywerId, Long contratLegalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deleteContractLegal(Long clientId, Long laywerId, Long contratLegalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ContractLegal> getAllContractLegalByClientId(Long clientId, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ContractLegal> getAllContractLegalByLawyerId(Long laywerId, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ContractLegal> getAllContractLegalByClientIdAndLawyerId(Long clientId, Long laywerId,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ContractLegal> getAllContractLegal(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContractLegal getContractLegalById(Long contractLegalId) {
		ContractLegal contractLegal = contractLegalRepository.findById(contractLegalId)
				.orElseThrow(() -> new ResourceNotFoundException("ContractLegal","Id",contractLegalId));
		return contractLegal;
	}

}
