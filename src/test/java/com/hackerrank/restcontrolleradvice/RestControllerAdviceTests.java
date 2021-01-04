package com.hackerrank.restcontrolleradvice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class RestControllerAdviceTests {
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testFizzException() throws Exception {
    mockMvc.perform(get("/controller_advice/fizz"))
            .andExpect(jsonPath("$.message").value("Fizz Exception has been thrown"))
            .andExpect(jsonPath("$.errorReason").value("Internal Server Error"))
            .andExpect(status().isInternalServerError());
  }

  @Test
  public void testBuzzException() throws Exception {
    mockMvc.perform(get("/controller_advice/buzz"))
            .andExpect(jsonPath("$.message").value("Buzz Exception has been thrown"))
            .andExpect(jsonPath("$.errorReason").value("Bad Request"))
            .andExpect(status().isBadRequest());
  }

  @Test
  public void testFizzBuzzException() throws Exception {
    mockMvc.perform(get("/controller_advice/fizzbuzz"))
            .andExpect(jsonPath("$.message").value("FizzBuzz Exception has been thrown"))
            .andExpect(jsonPath("$.errorReason").value("Insufficient Storage"))
            .andExpect(status().isInsufficientStorage());
  }

  @Test
  public void testFizzBuzzResponse() throws Exception {
    mockMvc.perform(get("/controller_advice/success"))
            .andExpect(jsonPath("$.message").value("Successfully completed fizzbuzz test"))
            .andExpect(jsonPath("$.statusCode").value("200"))
            .andExpect(status().isOk());
  }
}
