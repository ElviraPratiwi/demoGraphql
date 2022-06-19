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
public class LecturerSO extends MemberSO {

  public String lecturerCode;

  public LecturerSO(String id, String name, String lecturerCode) {
    super(id, name);
    this.lecturerCode = lecturerCode;
  }
}
