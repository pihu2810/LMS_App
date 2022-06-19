package com.bridgelabz.Lms.service;

import com.bridgelabz.Lms.dto.BankInfoDTO;
import com.bridgelabz.Lms.model.BankInfo;

import java.util.List;

public interface IBankService {
    BankInfo addBankInfo(BankInfoDTO bankInfoDto);
    List<BankInfo> getAllBankDeatils();
    BankInfo updateBankInfo(long id, BankInfoDTO bankInfoDto);
}
