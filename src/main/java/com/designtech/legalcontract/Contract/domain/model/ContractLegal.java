package com.designtech.legalcontract.Contract.domain.model;

import java.time.LocalDate;

import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.*;

@Entity
@Table(name = "contratlegal")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractLegal extends AuditModel{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Long clientId; //extraer por api :v 

    private Long lawyerId;

    private String description;

    private Long cost;

    @DateTimeFormat
    private LocalDate start_Date;

    @DateTimeFormat
    private LocalDate end_Date;
}
