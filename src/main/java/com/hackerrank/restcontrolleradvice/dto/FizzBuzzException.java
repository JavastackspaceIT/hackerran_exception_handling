package com.hackerrank.restcontrolleradvice.dto;

public class FizzBuzzException extends RuntimeException {
  private final String     message;
  private final String     errorReason;

  public FizzBuzzException(String message, String errorReason) {
    this.message = message;
    this.errorReason = errorReason;
  }

  public FizzBuzzException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1, String errorReason) {
    super(message, cause, enableSuppression, writableStackTrace);
    this.message = message1;
    this.errorReason = errorReason;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public String getErrorReason() {
    return errorReason;
  }
}
