package com.bridgelabz.Lms.service;

import com.bridgelabz.Lms.Util.EmailSenderService;
import com.bridgelabz.Lms.Util.TokenUtility;
import com.bridgelabz.Lms.dto.CandidateDTO;
import com.bridgelabz.Lms.exception.CandidateException;
import com.bridgelabz.Lms.model.Candidate;
import com.bridgelabz.Lms.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements ICandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    EmailSenderService sender;

    @Autowired
    TokenUtility tokenUtil;


    public String createCandidate(CandidateDTO candidateDTO) {
        Candidate candidate = new Candidate(candidateDTO);
        candidate.setId(sequenceGeneratorService.generateSequence(Candidate.SEQUENCE_NAME));
        candidateRepository.save(candidate);
        String token = tokenUtil.createToken((int) candidate.getId());
        sender.sendEmail(candidate.getEmail(), "Test Email", "Registered SuccessFully, hii: "
                +candidate.getFirstName()+"Please Click here to get data-> "
                +"http://localhost:8086/candidateDetails/gettoken/"+ token);
        return token;
    }
    public Candidate getByToken(String token) {
        long id = tokenUtil.decodeToken(token);
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if (candidate.isPresent()) {
            return candidate.get();
        } else {
            throw new CandidateException("Exception with id" + id + "does not exist!!");
        }
    }
        @Override
    public List<Candidate> getAll() {
        List<Candidate> candidate = candidateRepository.findAll();
        if(candidate.isEmpty()){
            throw  new CandidateException(HttpStatus.NOT_FOUND,"There is no data added");
        }
        return candidate;
    }
    @Override
    public Candidate getCandidateById(long id) {
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if(candidate.isPresent()){
            return candidate.get();
        }else
         throw new CandidateException("Id is not present");
    }

    @Override
    public List<Candidate> hiredCandidate(String status) {
        List<Candidate> hiredCandidate= candidateRepository.findCandidateByStatus(status);
        if (hiredCandidate.isEmpty()) {
            throw new CandidateException(HttpStatus.NOT_FOUND," Hired Candidates  not found");
        }
        return hiredCandidate;
    }

    @Override
    public Candidate updateCandidate(String token, CandidateDTO candidateDTO) {
        long id = tokenUtil.decodeToken(token);
        Optional<Candidate> hiredCandidate = candidateRepository.findById(id);
        if (hiredCandidate.isPresent()){
            hiredCandidate.get().setFirstName(candidateDTO.getFirstName());
            hiredCandidate.get().setLastName(candidateDTO.getLastName());
            hiredCandidate.get().setEmail(candidateDTO.getEmail());
            hiredCandidate.get().setPhonenumber(candidateDTO.getPhonenumber());
            hiredCandidate.get().setStatus(candidateDTO.getStatus());
            hiredCandidate.get().setCity(candidateDTO.getCity());
        }
        return candidateRepository.save(hiredCandidate.get());
    }

    @Override
    public long count1(String status) {
        return candidateRepository.countByStatusEquals(status);
    }

    @Override
    public Candidate updateStatus(String token, CandidateDTO candidateDto) {
        long id = tokenUtil.decodeToken(token);
        Optional<Candidate> updateStatus = candidateRepository.findById(id);
        updateStatus.get().setStatus(candidateDto.getStatus());
        return candidateRepository.save(updateStatus.get());
    }

    @Override
    public Candidate jobOfferMail(String token) {
        long id = tokenUtil.decodeToken(token);
        Optional<Candidate> hiredCandidate = candidateRepository.findById(id);
        if (hiredCandidate.isPresent()){
            sender.sendEmail(hiredCandidate.get().getEmail(), "Job Offer", " Hi " + hiredCandidate.get().getFirstName()
                    + "\n You have been Shortlisted  for the software engineer position. Congratulations!");

        }
        return hiredCandidate.get();
    }

    @Override
    public Candidate jobOfferMail(long id) {
        Optional<Candidate> hiredCandidate = candidateRepository.findById(id);
        if (hiredCandidate.isPresent()){
            sender.sendEmail(hiredCandidate.get().getEmail(), "Job Offer", " Hi " + hiredCandidate.get().getFirstName()
                    + "\n You have been Shortlisted for the software engineer position. Congratulations!");

        }
        return hiredCandidate.get();
    }

    @Override
    public Candidate updateCandidateId(long id, CandidateDTO hiredCandidateDto) {
        Optional<Candidate> candidate=candidateRepository.findById(id);
        if (candidate.isPresent()) {
            Candidate newCandidate = new Candidate(id, hiredCandidateDto);
            candidateRepository.save(newCandidate);
            return newCandidate;
        } else {
            throw new CandidateException(HttpStatus.NOT_FOUND, "Candidate not found by this Id");
        }
    }
    }




