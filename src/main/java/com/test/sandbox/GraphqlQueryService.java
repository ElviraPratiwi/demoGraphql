package com.test.sandbox;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
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
  private final LecturerRepository lecturerRepository;
  private final StudentRepository studentRepository;

  public CompletableFuture<String> helloWorld() {
    return Mono.just("Hello World").toFuture();
  }

  public CompletableFuture<List<Book>> findAllBooks() {
    return bookRepository.findAll().collectList().toFuture();
  }

  public CompletableFuture<List<Book>> findAllBookByType(BookType type) {
    return bookRepository.findAllByType(type).collectList().toFuture();
  }

  public CompletableFuture<Book> findBookById(String id) {
    return bookRepository.findBookById(id).toFuture();
  }

  public CompletableFuture<List<MemberSO>> findAllMember() {
    return Mono.zip(lecturerRepository.findAll()
            .map(lecturer -> new LecturerSO(lecturer.getId(), lecturer.getName(),
                lecturer.getLecturerCode())
            ).map(lecturerSO -> (MemberSO) lecturerSO)
            .collectList(), studentRepository.findAll()
            .map(student -> new StudentSO(student.getId(), student.getName(),
                student.getStudentCode())
            ).map(student -> (MemberSO) student)
            .collectList())
        .map(objects -> {
          objects.getT1().addAll(objects.getT2());
          return objects.getT1();
        })
        .toFuture();
  }
}
