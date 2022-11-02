package com.designtech.legalcontract.External.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.designtech.legalcontract.External.domain.model.Client;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("lawyer-service")
public interface LegizLawyer {
	@RequestMapping("/api/lawyer/findlawyer/{lawyerId}")
	Client findById(@PathVariable Long lawyerId);
	@RequestMapping("/api/lawyer/existlawyer/{lawyerId}")
	boolean existById(@PathVariable Long lawyerId);
}
