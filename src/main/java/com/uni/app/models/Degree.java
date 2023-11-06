package com.uni.app.models;

import lombok.Getter;

@Getter
public enum Degree {
  ASSISTANT("Assistant"),
  ASSOCIATE_PROFESSOR("Associate professor"),
  PROFESSOR("Professor");
  private final String name;

  Degree(String name) {
    this.name = name;
  }
}
