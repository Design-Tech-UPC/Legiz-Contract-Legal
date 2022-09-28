package com.designtech.legalcontract.Contract.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.designtech.legalcontract.Contract.domain.model.ContractLegal;

public interface ContractLegalService {
	ContractLegal createContratLegal(Long clientId, Long laywerId, ContractLegal contratLegal);
	ContractLegal updateContratLegal(Long clientId, Long laywerId, Long contratLegalId, ContractLegal contratLegalRequest);
    ResponseEntity<?> deleteContratLegal(Long clientId, Long laywerId, Long contratLegalId);
    Page<ContractLegal> getAllContratLegalByClientId(Long clientId, Pageable pageable);
    Page<ContractLegal> getAllContratLegalByLawyerId(Long laywerId, Pageable pageable);
    Page<ContractLegal> getAllContratLegalByClientIdAndLawyerId(Long clientId, Long laywerId, Pageable pageable);
    Page<ContractLegal> getAllContratLegal(Pageable pageable);
}
