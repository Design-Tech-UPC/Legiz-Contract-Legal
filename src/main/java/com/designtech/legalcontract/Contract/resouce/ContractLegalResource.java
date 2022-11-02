package com.designtech.legalcontract.Contract.resouce;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractLegalResource {

	private Long id;

    private String description;

    private Long cost;

    private LocalDate start_Date;

    private LocalDate end_Date;

    private Long idClient;

    private String nameClient;

    private String surnameClient;

    private String emailClient;

    private String passwordClient;

    private Long DNIClient;

    private LocalDate date_BirthdayClient;

    private String civil_StatusClient;

    private Long idLawyer;

    private String nameLawyer;

    private String surnameLawyer;

    private String emailLawyer;

    private String passwordLawyer;

    private Long DNILawyer;

    private LocalDate date_BirthdayLawyer;

}
