package com.test.sandbox;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

/**
 * Created by elvira.pratiwi on 23-May-22
 */
@Component
@RequiredArgsConstructor
public class GraphqlSubcriptionService implements GraphQLSubscriptionResolver {

    private final BookPublisher bookPublisher;

    public Publisher<Book> findBook() {
        return bookPublisher.findBook();
    }

}
