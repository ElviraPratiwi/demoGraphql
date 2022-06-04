package com.test.sandbox;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
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

    public CompletableFuture<Book> addBook(String name, String authorName, String description) {
        return bookRepository.save(Book.builder()
                        .name(name)
                        .authorName(authorName)
                        .description(description)
                        .build())
                .doOnSuccess(bookPublisher::publish)
                .toFuture();
    }

}
