package com.bridgelabz.Lms.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import javax.persistence.Id;

@Document(collection = "database_sequences")
@Data
@Component
public class DatabaseSequence
{
    @Id
    private String id;

    private long seq;
}
