package com.bridgelabz.Lms.dto;

import com.bridgelabz.Lms.model.BankInfo;
import com.bridgelabz.Lms.model.QualificationInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDTO
{
    private long id;
    private String firstName;
    private String lastName;
    private String status;
    private String email;
    private  String phonenumber;
    private String city;
    private BankInfo bankInfo;
    private QualificationInfo qualificationInfo;

}
