package com.cwc.credit.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cwc.credit.model.CreditCard;
import com.cwc.credit.model.enums.Company;
import com.cwc.credit.payload.CreditCardRequest;
import com.cwc.credit.payload.CreditCardResponse;
import com.cwc.credit.repository.CreditCardRepository;
import com.cwc.credit.service.CreditCardService;
import com.cwc.credit.utilities.RandomCVVNumber;
import com.cwc.credit.utilities.RandomCreditCardNumber;
import com.cwc.credit.utilities.RandomDate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {

	
	@Autowired
	private final CreditCardRepository creditCardRepository;
	
	@Override
	public CreditCardResponse addCardDetails(CreditCardRequest creditCardRequest) {
		
		//get company name here 
		String companyName = creditCardRequest.getCompany().toString(); // Assuming this gives the company name as a string
		
		
		//generate random card number
		String cardNumber = RandomCreditCardNumber.generateRandomCreditCardNumber(companyName);
		log.info(cardNumber);
		creditCardRequest.setCardNumber(cardNumber);
		
		//generate random CVV number
		String cvv = RandomCVVNumber.generateRandomCVV();
		creditCardRequest.setCvv(cvv);
		
		//generate random Date
//		String expirationDate = RandomDate.generateRandomExpirationDate();
//		creditCardRequest.setExpiryDate(new LocalDate(expirationDate));
		
		String expirationDate = RandomDate.generateDate();

//        // Convert the expirationDate string to LocalDate using the specified format
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
//        LocalDate localExpirationDate = LocalDate.parse(expirationDate, formatter);

//        creditCardRequest.setExpiryDate(localExpirationDate);
		creditCardRequest.setExpiryDate(expirationDate);
		
		
		CreditCard creditCard = CreditCard.builder()
				.cardholder(creditCardRequest.getCardholder())
				.cardNumber(creditCardRequest.getCardNumber())//
				.company(creditCardRequest.getCompany())
				.bank(creditCardRequest.getBank())
				.cvv(creditCardRequest.getCvv())//
				.expiryDate(creditCardRequest.getExpiryDate())//
				.build();
		log.info("saved data inside database {} " ,creditCard);
		this.creditCardRepository.save(creditCard);
		return MapToResponse(creditCard);
	}

	
	
	private CreditCardResponse MapToResponse(CreditCard creditCard) {
		CreditCardResponse cardResponse = CreditCardResponse.builder()
				.cardholder(creditCard.getCardholder())
				.cardNumber(creditCard.getCardNumber())
				.company(creditCard.getCompany())
				.bank(creditCard.getBank())
				.cvv(creditCard.getCvv())
				.expiryDate(creditCard.getExpiryDate())
				.build();
		return cardResponse;
	}

}
