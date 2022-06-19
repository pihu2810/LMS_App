package com.bridgelabz.Lms.repository;

import com.bridgelabz.Lms.model.QualificationInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationRepository extends MongoRepository<QualificationInfo, Long> {
}
