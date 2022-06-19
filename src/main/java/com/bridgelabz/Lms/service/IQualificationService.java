package com.bridgelabz.Lms.service;

import com.bridgelabz.Lms.dto.QualificationDto;
import com.bridgelabz.Lms.model.QualificationInfo;

import java.util.List;

public interface IQualificationService {
    QualificationInfo addQualificationData(QualificationDto qualificationDto);

    List<QualificationInfo> getQualificationData();

    QualificationInfo updateQualificationById(long id, QualificationDto qualificationDto);
}