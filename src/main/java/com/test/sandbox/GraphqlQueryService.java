package com.test.sandbox;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by elvira.pratiwi on 23-May-22
 */
@Component
@RequiredArgsConstructor
public class GraphqlQueryService implements GraphQLQueryResolver {

  private final BookRepository bookRepository;

  public CompletableFuture<String> helloWorld() {
    return Mono.just("Hello World").toFuture();
  }

  public CompletableFuture<List<Book>> findAllBooks() {
    return bookRepository.findAll().collectList().toFuture();
  }
  public CompletableFuture<Book> findBookById(String id) {
    return bookRepository.findBookById(id).toFuture();
  }
}
