package com.test.sandbox;

import graphql.kickstart.tools.GraphQLMutationResolver;
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
public class GraphqlMutationService implements GraphQLMutationResolver {

  private final BookRepository bookRepository;

  public CompletableFuture<Book> addBook(String name, String authorName, String description) {
    return bookRepository.save(Book.builder()
            .name(name)
            .authorName(authorName)
            .description(description)
        .build()).toFuture();
  }

}
