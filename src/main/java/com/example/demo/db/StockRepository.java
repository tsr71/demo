package com.example.demo.db;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface StockRepository extends MongoRepository<Stock, String> {
	
	@Query("{symbol: ?0}")
	public Stock findBySymbol(String s);

}
