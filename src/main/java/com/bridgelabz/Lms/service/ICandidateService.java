package com.bridgelabz.Lms.service;

import com.bridgelabz.Lms.dto.CandidateDTO;
import com.bridgelabz.Lms.model.Candidate;

import java.util.List;

public interface ICandidateService
{
    String createCandidate(CandidateDTO candidateDTO);
    Candidate getByToken(String token);
    List<Candidate> getAll();
    Candidate getCandidateById(long id);
 List<Candidate> hiredCandidate(String status);
    Candidate updateCandidate(String token, CandidateDTO candidateDTO);
    long count1(String status);
    Candidate updateStatus(String token, CandidateDTO candidateDto);

    Candidate jobOfferMail(String token);
    Candidate jobOfferMail(long id);

    Candidate updateCandidateId(long id, CandidateDTO hiredCandidateDto);
}
