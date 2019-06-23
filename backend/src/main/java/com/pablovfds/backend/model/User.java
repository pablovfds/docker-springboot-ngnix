package com.pablovfds.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document
public class User {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String username;
}
