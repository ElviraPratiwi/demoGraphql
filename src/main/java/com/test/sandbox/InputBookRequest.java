package com.test.sandbox;

import lombok.Builder;
import lombok.Data;

/**
 * Created by elvira.pratiwi on 20-Jun-22
 */
@Data
@Builder
public class InputBookRequest {
  private String name;
  private BookType type;
  private String authorName;
  private String description;
  private String category;
  private String sourceLanguage;
  private String targetLanguage;
}
