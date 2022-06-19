package com.test.sandbox.repository;

import com.sun.corba.se.spi.ior.ObjectId;
import com.test.sandbox.model.Book;
import com.test.sandbox.model.BookType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by elvira.pratiwi on 23-May-22
 */
public interface BookRepository extends ReactiveMongoRepository<Book, ObjectId> {
  Mono<Book> findBookById(String id);
  Flux<Book> findAllByType(BookType type);
}
