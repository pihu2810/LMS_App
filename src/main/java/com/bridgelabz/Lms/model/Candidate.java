package com.bridgelabz.Lms.model;

import com.bridgelabz.Lms.dto.CandidateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Transient;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Candidate")
public class Candidate
{
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private long id;

    private String firstName;
    private String lastName;
    private String status;
    private String email;
    private  String phonenumber;
    private String city;
    private BankInfo bankInfo;
    private QualificationInfo qualificationInfo;

    public Candidate(CandidateDTO dto) {
        super();
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.status = dto.getStatus();
        this.email = dto.getEmail();
        this.phonenumber = dto.getPhonenumber();
        this.city = dto.getCity();
        this.bankInfo=dto.getBankInfo();
        this.qualificationInfo=dto.getQualificationInfo();
    }


    public Candidate(long id, CandidateDTO hiredCandidateDto)
    {
        this.firstName = hiredCandidateDto.getFirstName();
        this.lastName = hiredCandidateDto.getLastName();
        this.status = hiredCandidateDto.getStatus();
        this.email = hiredCandidateDto.getEmail();
        this.phonenumber = hiredCandidateDto.getPhonenumber();
        this.city = hiredCandidateDto.getCity();
        this.bankInfo=hiredCandidateDto.getBankInfo();
        this.qualificationInfo=hiredCandidateDto.getQualificationInfo();
    }
}
