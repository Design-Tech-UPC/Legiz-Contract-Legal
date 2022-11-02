package com.designtech.legalcontract.unitTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.designtech.legalcontract.Contract.domain.model.ContractLegal;
import com.designtech.legalcontract.Contract.domain.repository.ContractLegalRepository;
import com.designtech.legalcontract.Contract.domain.service.ContractLegalService;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
public class ContractLegalSerciveImplTest {

	@Autowired
	private ContractLegalService contractLegalService;

	@Test
	@DisplayName("When create contractlegalService with correct Client and Lawyer then return Post")
	public void WhenCreateContractLegalServiceWithCorrectClientAndLawyerThenReturnPost() {
		// arrange
		// Client
		Long clientId = 1L;
		// Lawyer
		Long lawyerId = 1L;
		//contractLegal
		Long id = 1L;
		ContractLegal contractLegal = new ContractLegal();
		//Act
		contractLegal.setClientId(clientId);
		contractLegal.setLawyerId(lawyerId);
		ContractLegal foundContractLegal = contractLegalService.getContractLegalById(id);
		//Assert
		assertThat(foundContractLegal.getId().equals(id));
	}
}
