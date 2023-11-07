package com.uni.app.models.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Degree {
  ASSISTANT("Assistant"),
  ASSOCIATE_PROFESSOR("Associate professor"),
  PROFESSOR("Professor");

  private final String name;
}
