package com.uni.app.services;

import com.uni.app.models.Lecturer;

import java.util.List;

public interface LecturerService {
  List<Lecturer> findNameSurnameCoincidesTemplate(String template);
}
