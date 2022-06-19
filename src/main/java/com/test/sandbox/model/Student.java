package com.test.sandbox.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by elvira.pratiwi on 23-May-22
 */
@Document(collection = "student")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student extends Member {

  public String studentCode;

  public Student(String id, String name, String studentCode) {
    super(id, name);
    this.studentCode = studentCode;
  }
}
