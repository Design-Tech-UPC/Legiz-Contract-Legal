package com.designtech.legalcontract.Contract.resouce;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class SaveContractLegalResource {
	 private String description;

	    private Long cost;

	    @DateTimeFormat
	    private LocalDate start_Date;

	    @DateTimeFormat
	    private LocalDate end_Date;

	    public SaveContractLegalResource() {
	    }

	    public SaveContractLegalResource(String description, Long cost, LocalDate start_Date, LocalDate end_Date) {
	        this.description = description;
	        this.cost = cost;
	        this.start_Date = start_Date;
	        this.end_Date = end_Date;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public SaveContractLegalResource setDescription(String description) {
	        this.description = description;
	        return this;
	    }

	    public Long getCost() {
	        return cost;
	    }

	    public SaveContractLegalResource setCost(Long cost) {
	        this.cost = cost;
	        return this;
	    }

	    public LocalDate getStart_Date() {
	        return start_Date;
	    }

	    public SaveContractLegalResource setStart_Date(LocalDate start_Date) {
	        this.start_Date = start_Date;
	        return this;
	    }

	    public LocalDate getEnd_Date() {
	        return end_Date;
	    }

	    public SaveContractLegalResource setEnd_Date(LocalDate end_Date) {
	        this.end_Date = end_Date;
	        return this;
	    }
}
