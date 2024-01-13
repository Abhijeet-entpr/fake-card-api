package com.cwc.credit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cwc.credit.model.CreditCard;


@Repository
public interface CreditCardRepository extends MongoRepository<CreditCard, String> {

}
