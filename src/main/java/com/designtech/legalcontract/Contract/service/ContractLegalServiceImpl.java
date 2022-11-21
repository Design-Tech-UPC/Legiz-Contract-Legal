package com.designtech.legalcontract.Contract.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.designtech.legalcontract.External.services.LegizClient;
import com.designtech.legalcontract.External.services.LegizLawyer;
import com.designtech.legalcontract.Contract.domain.model.ContractLegal;
import com.designtech.legalcontract.Contract.domain.repository.ContractLegalRepository;
import com.designtech.legalcontract.Contract.domain.service.ContractLegalService;

import com.designtech.legalcontract.exception.ResourceNotFoundException;

@Service
public class ContractLegalServiceImpl implements ContractLegalService {

	private final LegizClient legizClient;

	private final LegizLawyer legizLawyer;

	private final ContractLegalRepository contractLegalRepository;

	@Autowired
	public ContractLegalServiceImpl(LegizClient legizClient, LegizLawyer legizLawyer,
			ContractLegalRepository contractLegalRepository) {
		this.legizClient = legizClient;
		this.legizLawyer = legizLawyer;
		this.contractLegalRepository = contractLegalRepository;
	}

	@Override
	public ContractLegal createContractLegal(Long clientId, Long lawyerId, ContractLegal contractLegal) {
		if (!legizClient.existById(clientId))
			throw new ResourceNotFoundException("Client", "Id", clientId);

		if (!legizLawyer.existById(lawyerId))
			throw new ResourceNotFoundException("Lawyer", "Id", lawyerId);
		contractLegal.setClientId(clientId);
		contractLegal.setLawyerId(lawyerId);
		return contractLegalRepository.save(contractLegal);
	}

	@Override
	public ContractLegal updateContractLegal(Long clientId, Long laywerId, Long contractLegalId,
			ContractLegal contractLegalRequest) {
		if (!legizClient.existById(clientId))
			throw new ResourceNotFoundException("Client", "Id", clientId);

		else if (!legizLawyer.existById(laywerId))
			throw new ResourceNotFoundException("Lawyer", "Id", laywerId);

		return contractLegalRepository.findById(contractLegalId).map(contractLegal -> {
			contractLegal.setDescription(contractLegalRequest.getDescription());
			contractLegal.setCost(contractLegalRequest.getCost());
			contractLegal.setStart_Date(contractLegalRequest.getStart_Date());
			contractLegal.setEnd_Date(contractLegalRequest.getEnd_Date());
			return contractLegalRepository.save(contractLegal);
		}).orElseThrow(() -> new ResourceNotFoundException("Client Id" + clientId + "Lawyer Id" + laywerId));

	}

	@Override
	public ResponseEntity<?> deleteContractLegal(Long clientId, Long laywerId, Long contractLegalId) {
		if (!legizClient.existById(clientId))
			throw new ResourceNotFoundException("Client", "Id", clientId);

		else if (!legizLawyer.existById(laywerId))
			throw new ResourceNotFoundException("Lawyer", "Id", laywerId);

		return contractLegalRepository.findById(contractLegalId).map(contratLegal -> {
			contractLegalRepository.delete(contratLegal);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Consult Legal", "Id", contractLegalId));
	}

	@Override
	public Page<ContractLegal> getAllContractLegalByClientId(Long clientId, Pageable pageable) {
		return contractLegalRepository.findByClientId(clientId, pageable);
	}

	@Override
	public Page<ContractLegal> getAllContractLegalByLawyerId(Long laywerId, Pageable pageable) {
		return contractLegalRepository.findByLawyerId(laywerId, pageable);
	}

	@Override
	public Page<ContractLegal> getAllContractLegalByClientIdAndLawyerId(Long clientId, Long laywerId,
			Pageable pageable) {
		return contractLegalRepository.findByClientIdAndLawyerId(clientId, laywerId, pageable);
	}

	@Override
	public Page<ContractLegal> getAllContractLegal(Pageable pageable) {
		return contractLegalRepository.findAll(pageable);
	}

	@Override
	public ContractLegal getContractLegalById(Long contractLegalId) {
		ContractLegal contractLegal = contractLegalRepository.findById(contractLegalId)
				.orElseThrow(() -> new ResourceNotFoundException("ContractLegal", "Id", contractLegalId));
		return contractLegal;
	}

}
