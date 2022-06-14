package com.hunger.order.feignclient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hunger.order.model.TransactionHistory;
import com.hunger.order.model.TransferBalanceRequestEntity;



@org.springframework.cloud.openfeign.FeignClient
(value = "bankingapplication", url = "http://localhost:8080/PaymentGetway/account")
public interface PaymentClient {

	@PutMapping("/moneytransfer")
	public ResponseEntity<TransactionHistory> sendMoney(   
			@RequestBody TransferBalanceRequestEntity transferBalanceRequest);	
}
