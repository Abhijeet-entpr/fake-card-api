package com.cwc.credit.service;

import com.cwc.credit.payload.CreditCardRequest;
import com.cwc.credit.payload.CreditCardResponse;

public interface CreditCardService {
	
	public CreditCardResponse addCardDetails(CreditCardRequest creditCardRequest);

}
