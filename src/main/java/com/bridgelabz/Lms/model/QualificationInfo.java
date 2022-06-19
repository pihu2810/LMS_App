package com.bridgelabz.Lms.model;

import com.bridgelabz.Lms.dto.QualificationDto;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Transient;

@Document(collection = "qualification_info")
@Data
public class QualificationInfo {

    @Transient
    public static final String SEQUENCE_NAME = "qualification_sequence";

    @Id
    private long id;

    private String collageName;
    private String degree;
    private String percentage;
    private String yearOfPassing;
    private String course;

    public QualificationInfo() {
        super();
    }

    public QualificationInfo(QualificationDto qualificationDto) {
        this.collageName = qualificationDto.getCollageName();
        this.degree = qualificationDto.getDegree();
        this.percentage = qualificationDto.getPercentage();
        this.yearOfPassing = qualificationDto.getYearOfPassing();
        this.course = qualificationDto.getCourse();
    }

}
