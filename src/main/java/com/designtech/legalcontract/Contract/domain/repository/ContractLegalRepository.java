package com.designtech.legalcontract.Contract.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.designtech.legalcontract.Contract.domain.model.ContractLegal;

@Repository
public interface ContractLegalRepository extends JpaRepository<ContractLegal, Long> {
    public Page<ContractLegal> findById(Long Id, Pageable pageable);
    Page<ContractLegal> findByClientId(Long ClientId, Pageable pageable);
    Page<ContractLegal> findByLawyerId(Long LawyerId, Pageable pageable);
    public Page<ContractLegal> findByClientIdAndLawyerId(Long ClientId, Long LawyerId, Pageable pageable);
}
