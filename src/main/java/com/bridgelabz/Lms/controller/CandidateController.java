package com.bridgelabz.Lms.controller;


import com.bridgelabz.Lms.dto.CandidateDTO;
import com.bridgelabz.Lms.dto.ResponseDTO;
import com.bridgelabz.Lms.model.Candidate;
import com.bridgelabz.Lms.service.ICandidateService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/candidateDetails")
public class CandidateController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Autowired
    private ICandidateService iCandidateService;

    @PostMapping("/importCustomers")
    public void importCsvToDBJob() {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("startAt", System.currentTimeMillis()).toJobParameters();
        try {
            jobLauncher.run(job, jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException |
                JobParametersInvalidException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/addCandidate")
    public ResponseEntity<ResponseDTO> createUser(@RequestBody CandidateDTO candidateDTO) {
        String Candidate = iCandidateService.createCandidate(candidateDTO);
        ResponseDTO response = new ResponseDTO("Hired Candidate Added Successfully !!!", Candidate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/gettoken/{token}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable String token) {
        Candidate candidate = iCandidateService.getByToken(token);
        ResponseDTO response = new ResponseDTO("GET CALL FOR VIEW PROFILE SUCCESSFUL", candidate);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAll() {
        List<Candidate> candidates = iCandidateService.getAll();
        ResponseDTO response = new ResponseDTO("GET CALL FOR  CANDIDATES SUCCESSFUL", candidates);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable long id) {
        Candidate candidate = iCandidateService.getCandidateById(id);
        ResponseDTO response = new ResponseDTO("GET CALL FOR VIEW PROFILE SUCCESSFUL", candidate);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/getHired/{status}")
    public ResponseEntity<ResponseDTO> getHired(@PathVariable String status) {
        List hiredCandidate = iCandidateService.hiredCandidate(status);
        ResponseDTO response = new ResponseDTO("GET CALL FOR HIRED CANDIDATES SUCCESSFUL", hiredCandidate);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PutMapping("/update/{token}")
    public ResponseEntity<ResponseDTO> updateCandidateData(@PathVariable String token,
                                                           @RequestBody CandidateDTO hiredCandidateDto) {
        Candidate hiredCandidate = iCandidateService.updateCandidate(token, hiredCandidateDto);
        ResponseDTO response = new ResponseDTO("UPDATED CANDIDATE DATA SUCCESSFULLY !!!", hiredCandidate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/count/{status}")
    public ResponseEntity<ResponseDTO> getCount (@PathVariable String status){
        long hiredCandidate = iCandidateService.count1(status);
        ResponseDTO response = new ResponseDTO("Candidates Count",hiredCandidate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/updateStatus/{token}")
    public ResponseEntity<ResponseDTO> getStatus(@PathVariable String token, @RequestBody CandidateDTO hiredCandidateDto){
        Candidate hiredCandidate = iCandidateService.updateStatus(token, hiredCandidateDto);
        ResponseDTO responseDto = new ResponseDTO("Candidate Status Updated", hiredCandidate);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping("/jobofferMail/{token}")
    public ResponseEntity<ResponseDTO> sendOffer(@PathVariable String token){
        Candidate hiredCandidate = iCandidateService.jobOfferMail(token);
        ResponseDTO response = new ResponseDTO("Email sent successfully", hiredCandidate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/joboffer/{id}")
    public ResponseEntity<ResponseDTO> sendOffer(@PathVariable long id){
        Candidate hiredCandidate = iCandidateService.jobOfferMail(id);
        ResponseDTO response = new ResponseDTO("Email sent successfully", hiredCandidate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}