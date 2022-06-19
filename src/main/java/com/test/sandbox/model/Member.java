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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
  public String id;
  public String name;
}
