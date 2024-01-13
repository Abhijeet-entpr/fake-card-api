package com.cwc.credit.model;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.cwc.credit.model.enums.Bank;
import com.cwc.credit.model.enums.Company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Document(collection = "credit_card")
public class CreditCard {

	@Id
	private String id;
	private String cardholder;
	private String cardNumber;
	@Field("company")
	private Company company;
	@Field("bank")
	private Bank bank;
	private String expiryDate;
	private String cvv;
}
