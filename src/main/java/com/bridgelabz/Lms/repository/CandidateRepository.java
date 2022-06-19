package com.bridgelabz.Lms.repository;

import com.bridgelabz.Lms.model.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableMongoRepositories
public interface CandidateRepository extends MongoRepository<Candidate, Long>
{

    List<Candidate> findCandidateByStatus(String status);
    Long countByStatusEquals(String Status);
}
