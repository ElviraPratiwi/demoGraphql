package com.test.sandbox.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by elvira.pratiwi on 23-May-22
 */
@Document(collection = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
public class Book {
  public String id;
  public BookType type;
  public String name;
  public String authorName;
  public String description;
}
