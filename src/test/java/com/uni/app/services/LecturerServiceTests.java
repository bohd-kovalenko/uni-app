package com.uni.app.services;

import com.uni.app.models.Lecturer;
import com.uni.app.models.enums.Degree;
import com.uni.app.repositories.LecturerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class LecturerServiceTests {
  @MockBean
  private LecturerService underTest;
  @Mock
  private LecturerRepository lecturerRepository;

  @Test
  public void testNameSurnameCoincidesTemplate() {
    String testTemplate = "val";
    List<Lecturer> expectedResult =
        List.of(new Lecturer(1, null, Degree.ASSISTANT, "Ivan", "Mirnov", 999.0),
            new Lecturer(2, null, Degree.PROFESSOR, "Petro", "Ivanov", 1111.0));
    when(lecturerRepository.findNameSurnameCoincidesTemplate(testTemplate))
        .thenReturn(expectedResult);

    List<Lecturer> actualResult = underTest.findNameSurnameCoincidesTemplate(testTemplate);

    assertEquals(expectedResult, actualResult);
  }
}
