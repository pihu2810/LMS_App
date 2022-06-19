package com.bridgelabz.Lms.controller;

import com.bridgelabz.Lms.dto.BankInfoDTO;
import com.bridgelabz.Lms.dto.ResponseDTO;
import com.bridgelabz.Lms.model.BankInfo;
import com.bridgelabz.Lms.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankInfo")
public class BankController {
    @Autowired
    IBankService iBankService;

    @PostMapping("/addData")
    public ResponseEntity<ResponseDTO> addingBankDetails(@RequestBody BankInfoDTO bankInfoDto) {
        BankInfo bank = iBankService.addBankInfo(bankInfoDto);
        ResponseDTO responseDTO = new ResponseDTO("Bank Info Added Successfully", bank);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getallbankDetails")
    public ResponseEntity<ResponseDTO> getDetails() {
        List<BankInfo> list = iBankService.getAllBankDeatils();
        ResponseDTO responseDTO = new ResponseDTO("Bank Details", list);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/updatebankdetails/{id}")
    public ResponseEntity<ResponseDTO> updateInfo(@PathVariable long id, @RequestBody BankInfoDTO bankInfoDto) {
        BankInfo bank = iBankService.updateBankInfo(id, bankInfoDto);
        ResponseDTO responseDTO = new ResponseDTO("Bank Data Successfully Updated", bank);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}