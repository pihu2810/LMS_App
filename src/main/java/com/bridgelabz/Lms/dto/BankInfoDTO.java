package com.bridgelabz.Lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BankInfoDTO
{
    private long id;
    private String bankName;
    private String bankAccountNumber;
    private String ifscCode;
    private String branchName;

}
