package com.springmongo.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")
public class StudentDTO {
    @Id
    private String id;
    private String name;
    private int age;
    private String gender;
    private Date createdAt;
    private Date updatedAt;

}
