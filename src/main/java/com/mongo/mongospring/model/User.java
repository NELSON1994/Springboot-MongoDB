package com.mongo.mongospring.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection= "User")
public class User {
    @Transient
    public static final String SEQUENCE_NAME="user_sequence";
    @Id
    private int id;
    private String firstName;
    private String lastName;

    //one to many
    private List<Product> products;
    //one to one
    private Address address;

}
