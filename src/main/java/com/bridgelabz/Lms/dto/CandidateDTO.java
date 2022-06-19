package com.bridgelabz.Lms.dto;

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

}
