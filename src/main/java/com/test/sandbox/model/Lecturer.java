package com.test.sandbox.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by elvira.pratiwi on 23-May-22
 */
@Document(collection = "lecturer")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Lecturer extends Member {
  public String lecturerCode;

  public Lecturer(String id, String name, String lecturerCode) {
    super(id, name);
    this.lecturerCode = lecturerCode;
  }
}
