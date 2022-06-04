package com.test.sandbox;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.FluxSink;

/**
 * Created by elvira.pratiwi on 23-May-22
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class BookPublisher {
    private final FluxProcessor<Book, Book> processor = DirectProcessor.<Book>create().serialize();
    private final FluxSink<Book> sink = processor.sink();

    public void publish(Book book) {
        sink.next(book);
    }

    public Publisher<Book> findBook() {
        return processor.map(book -> {
            log.info("publishing book : {}", book);
            return book;
        });
    }
}
