package com.designtech.legalcontract.Contract.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.designtech.legalcontract.Contract.resouce.ContractLegalResource;
import com.designtech.legalcontract.Contract.resouce.SaveContractLegalResource;
import javax.validation.Valid;

import com.designtech.legalcontract.Contract.domain.model.ContractLegal;
import com.designtech.legalcontract.Contract.domain.service.ContractLegalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/contractlegal")
public class ContractLegalController {

	@Autowired
	private ContractLegalService contractLegalService;

	@Autowired
	private ModelMapper mapper;

	@Operation(summary = "Create Contrat Legal", description = "Create Contrat Legal", tags = { "contrat_legals" })
	@PostMapping("/client/{clientId}/lawyer/{lawyerId}/contrat_legals")
	public ContractLegalResource createContractLegal(@PathVariable Long clientId, @PathVariable Long lawyerId,
			@Valid @RequestBody SaveContractLegalResource resource) {
		return convertToResource(
				contractLegalService.createContractLegal(clientId, lawyerId, convertToEntity(resource)));
	}

	private ContractLegal convertToEntity(SaveContractLegalResource resource) {
		return mapper.map(resource, ContractLegal.class);
	}

	@Operation(summary = "Delete Contrat legal by client ID and lawyer ID", description = "Delete Contrat legal by client ID and lawyer ID", tags = {
			"contrat_legals" })
	@DeleteMapping("/client/{clientId}/lawyer/{lawyerId}/contrat_legals/{contratLegalId}")
	public ResponseEntity<?> deleteContratLegal(@PathVariable Long clientId, @PathVariable Long lawyerId,
			@PathVariable Long contratLegalId) {
		return contractLegalService.deleteContractLegal(clientId, lawyerId, contratLegalId);
	}

	@Operation(summary = "Update contrat legal by client ID and lawyer ID", description = "Update contrat legal by client ID and lawyer ID", tags = {
			"contrat_legals" })
	@PutMapping("/client/{clientId}/lawyer/{lawyerId}/contrat_legals/{contratLegalId}")
	public ContractLegalResource updateContratLegal(@PathVariable Long clientId, @PathVariable Long lawyerId,
			@PathVariable Long contratLegalId) {
		return convertToResource(contractLegalService.updateContractLegal(clientId, lawyerId, contratLegalId));
	}

	@Operation(summary = "Get Contrat Legal", description = "Get all Contrat Legal by client Id", tags = {
			"contrat_legals" })
	@GetMapping("/client/{clientId}/contrat_legals")
	public Page<ContractLegalResource> getAllContratLegalByClientId(@PathVariable Long clientId, Pageable pageable) {
		Page<ContractLegal> contratLegalPage = contractLegalService.getAllContractLegalByClientId(clientId, pageable);
		List<ContractLegalResource> resources = contratLegalPage.getContent().stream().map(this::convertToResource)
				.collect(Collectors.toList());
		return new PageImpl<>(resources, pageable, resources.size());
	}

	private ContractLegalResource convertToResource(ContractLegal entity) {
		return mapper.map(entity, ContractLegalResource.class);
	}

}
