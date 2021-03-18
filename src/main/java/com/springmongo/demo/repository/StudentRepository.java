package com.springmongo.demo.repository;

import com.springmongo.demo.model.StudentDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<StudentDTO,String> {


}
