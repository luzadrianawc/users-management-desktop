package com.jcaa.usersmanagement.domain.exception;

public final class InvalidResearchProductTypeException extends DomainException {

  private static final String MESSAGE_INVALID = "The research product type '%s' is not valid.";

  private InvalidResearchProductTypeException(final String message) {
    super(message);
  }

  public static InvalidResearchProductTypeException becauseValueIsInvalid(final String value) {
    return new InvalidResearchProductTypeException(String.format(MESSAGE_INVALID, value));
  }
}