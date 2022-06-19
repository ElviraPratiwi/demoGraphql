package com.test.sandbox;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by elvira.pratiwi on 23-May-22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentSO extends MemberSO{

  public String studentCode;
  public StudentSO(String id, String name, String studentCode) {
    super(id, name);
    this.studentCode = studentCode;
  }
}
