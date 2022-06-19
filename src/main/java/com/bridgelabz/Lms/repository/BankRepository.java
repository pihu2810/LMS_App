package com.bridgelabz.Lms.repository;

import com.bridgelabz.Lms.model.BankInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends MongoRepository<BankInfo, Long>
{

}
