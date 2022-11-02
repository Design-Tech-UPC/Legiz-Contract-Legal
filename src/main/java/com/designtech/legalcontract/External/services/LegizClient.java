package com.designtech.legalcontract.External.services;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.designtech.legalcontract.External.domain.model.Client;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("client-service")
public interface LegizClient {
	@RequestMapping("/api/client/findclient/{clientId}")
	Client findById(@PathVariable Long clientId);
	@RequestMapping("/api/client/existClient/{clientId}")
	boolean existById(@PathVariable Long clientId);
}
