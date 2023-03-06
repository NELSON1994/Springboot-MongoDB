package com.mongo.mongospring.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection= "Address")
public class Address {
    @Id
    private int id;
    private String city;
    private int streetCode;
}
