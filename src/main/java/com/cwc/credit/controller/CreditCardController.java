package com.cwc.credit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cwc.credit.payload.CreditCardRequest;
import com.cwc.credit.payload.CreditCardResponse;
import com.cwc.credit.service.CreditCardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//contribute by Abhijeet SDE @ Trilectus pvt ltd
@RestController
@RequestMapping("/api/v1/card")
@Slf4j
@RequiredArgsConstructor
public class CreditCardController {
	
	@Autowired
	private final CreditCardService creditCardService;
	
	@PostMapping
	public ResponseEntity<CreditCardResponse> addCardDetails(@RequestBody CreditCardRequest creditCardRequest){
		
		CreditCardResponse cardDetails = this.creditCardService.addCardDetails(creditCardRequest);
		log.info("Credit card details saved {}", cardDetails);
		return new ResponseEntity<CreditCardResponse>(cardDetails,HttpStatus.CREATED);
		
	}

}
