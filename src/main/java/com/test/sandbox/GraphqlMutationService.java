package com.test.sandbox;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.test.sandbox.model.Book;
import com.test.sandbox.model.InputBookRequest;
import com.test.sandbox.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * Created by elvira.pratiwi on 23-May-22
 */
@Component
@RequiredArgsConstructor
public class GraphqlMutationService implements GraphQLMutationResolver {

  private final BookRepository bookRepository;
  private final BookPublisher bookPublisher;

  public CompletableFuture<Book> addBook(InputBookRequest request) {
    return bookRepository.save(Book.builder()
            .name(request.getName())
            .type(request.getType())
            .authorName(request.getAuthorName())
            .description(request.getDescription())
            .build())
        .doOnSuccess(bookPublisher::publish)
        .toFuture();
  }

  public CompletableFuture<Book> updateBook(String id, InputBookRequest request) {
    return bookRepository.findBookById(id)
        .flatMap(book -> {
          book.setName(request.getName());
          book.setType(request.getType());
          book.setAuthorName(request.getAuthorName());
          book.setDescription(request.getDescription());
          return bookRepository.save(book);
        })
        .doOnSuccess(bookPublisher::publish)
        .toFuture();
  }

}
