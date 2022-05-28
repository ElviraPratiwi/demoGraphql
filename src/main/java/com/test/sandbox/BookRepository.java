package com.test.sandbox;

import com.sun.corba.se.spi.ior.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * Created by elvira.pratiwi on 23-May-22
 */
public interface BookRepository extends ReactiveMongoRepository<Book, ObjectId> {
  Mono<Book> findBookById(String id);
}
