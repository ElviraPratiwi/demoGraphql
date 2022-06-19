package com.test.sandbox;

import com.sun.corba.se.spi.ior.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by elvira.pratiwi on 23-May-22
 */
public interface StudentRepository extends ReactiveMongoRepository<Student, ObjectId> {
}
