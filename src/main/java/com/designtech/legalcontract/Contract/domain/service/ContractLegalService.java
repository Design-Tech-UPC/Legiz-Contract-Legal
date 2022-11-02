package com.designtech.legalcontract.Contract.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.designtech.legalcontract.Contract.domain.model.ContractLegal;

public interface ContractLegalService {
	ContractLegal createContractLegal(Long clientId, Long laywerId, ContractLegal contractLegal);
	ContractLegal updateContractLegal(Long clientId, Long laywerId, Long contratLegalId);
    ResponseEntity<?> deleteContractLegal(Long clientId, Long laywerId, Long contratLegalId);
    Page<ContractLegal> getAllContractLegalByClientId(Long clientId, Pageable pageable);
    Page<ContractLegal> getAllContractLegalByLawyerId(Long laywerId, Pageable pageable);
    Page<ContractLegal> getAllContractLegalByClientIdAndLawyerId(Long clientId, Long laywerId, Pageable pageable);
    Page<ContractLegal> getAllContractLegal(Pageable pageable);
    ContractLegal getContractLegalById(Long contractLegalId);
}
