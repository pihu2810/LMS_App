package com.bridgelabz.Lms.service;

import com.bridgelabz.Lms.dto.QualificationDto;
import com.bridgelabz.Lms.model.QualificationInfo;
import com.bridgelabz.Lms.repository.QualificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QualificationService implements IQualificationService {

    @Autowired
    QualificationRepository qualificationRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Override
    public QualificationInfo addQualificationData(QualificationDto qualificationDto) {
        QualificationInfo info = new QualificationInfo(qualificationDto);
        info.setId(sequenceGeneratorService.generateSequence(QualificationInfo.SEQUENCE_NAME));
        return qualificationRepository.save(info);
    }

    @Override
    public List<QualificationInfo> getQualificationData() {
        List<QualificationInfo> list = qualificationRepository.findAll();
        return list;
    }

    @Override
    public QualificationInfo updateQualificationById(long id, QualificationDto qualificationDto) {
        Optional<QualificationInfo> updateData = qualificationRepository.findById(id);
        if (updateData.isPresent()) {
            updateData.get().setCollageName(qualificationDto.getCollageName());
            updateData.get().setDegree(qualificationDto.getDegree());
            updateData.get().setPercentage(qualificationDto.getPercentage());
            updateData.get().setYearOfPassing(qualificationDto.getYearOfPassing());
            updateData.get().setCourse(qualificationDto.getCourse());
        }
        return qualificationRepository.save(updateData.get());
    }
}