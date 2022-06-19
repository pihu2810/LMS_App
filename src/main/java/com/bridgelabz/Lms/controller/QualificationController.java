package com.bridgelabz.Lms.controller;

import com.bridgelabz.Lms.dto.QualificationDto;
import com.bridgelabz.Lms.dto.ResponseDTO;
import com.bridgelabz.Lms.model.QualificationInfo;
import com.bridgelabz.Lms.service.IQualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidateQualification")
public class QualificationController {

    @Autowired
    IQualificationService iQualificationService;

    @PostMapping("/addQualification")
    public ResponseEntity<ResponseDTO> addQualification(@RequestBody QualificationDto qualificationDto) {
        QualificationInfo qualificationInfo = iQualificationService.addQualificationData(qualificationDto);
        ResponseDTO responseDTO = new ResponseDTO("Candidate qualification is added..",qualificationInfo);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getQualificationData")
    public ResponseEntity<ResponseDTO> getQualificationData(){
        List<QualificationInfo> list = iQualificationService.getQualificationData();
        ResponseDTO responseDTO = new ResponseDTO("List of all qualification candidate", list);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/updateQualificationById/{id}")
    public ResponseEntity<ResponseDTO> updateQualification(@PathVariable long id, @RequestBody QualificationDto qualificationDto){
        QualificationInfo qualificationInfo = iQualificationService.updateQualificationById(id, qualificationDto);
        ResponseDTO responseDTO = new ResponseDTO("Qualification data successfully updated..", qualificationInfo);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}