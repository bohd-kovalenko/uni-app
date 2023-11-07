package com.uni.app.controllers.console;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DepartmentShellHandlerTests {
  private static final PrintStream DEFAULT_SYSTEM_OUT = System.out;
  @MockBean
  private DepartmentShellHandler underTest;

  @SneakyThrows
  @BeforeEach
  void setUp() {
    Field enabledField = DepartmentShellHandler.class.getField("enabled");
    enabledField.set(underTest, true);
  }

  @AfterEach
  void tearDown() {
    System.setOut(DEFAULT_SYSTEM_OUT);
  }

  @Test
  public void testHandleEnableCommand() {
    String expectedOutput = "You successfully enabled shell interaction!";
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(output));

    underTest.handleEnableCommand();
    String consoleOutput = originalOut.toString().trim();

    assertEquals(expectedOutput, consoleOutput);
  }

  @Test
  public void testHandleDisableCommand() {
    String expectedOutput = "You successfully disabled shell interaction!";
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(output));

    underTest.handleDisableCommand();
    String consoleOutput = originalOut.toString().trim();

    assertEquals(expectedOutput, consoleOutput);
  }

}
