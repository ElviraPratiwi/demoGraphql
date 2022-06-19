package com.test.sandbox;

import com.coxautodev.graphql.tools.SchemaParserDictionary;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by elvira.pratiwi on 20-Jun-22
 */
@Component
public class GraphqlConfig {
  @Bean
  public SchemaParserDictionary schemaParserDictionary() {
    return new SchemaParserDictionary()
        .add(LecturerSO.class)
        .add(StudentSO.class);
  }
}
