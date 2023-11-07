package com.uni.app.services.impl;

import com.uni.app.models.Lecturer;
import com.uni.app.repositories.LecturerRepository;
import com.uni.app.services.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LecturerServiceImpl implements LecturerService {
  private final LecturerRepository repository;

  @Override
  public List<Lecturer> findNameSurnameCoincidesTemplate(String template) {
    return repository
        .findNameSurnameCoincidesTemplate(template);
  }
}
