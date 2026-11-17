package com.jcaa.usersmanagement.domain.exception;

public final class InvalidResearchProductStatusException extends DomainException {

  private static final String MESSAGE_INVALID = "The research product status '%s' is not valid.";

  private InvalidResearchProductStatusException(final String message) {
    super(message);
  }

  public static InvalidResearchProductStatusException becauseValueIsInvalid(final String value) {
    return new InvalidResearchProductStatusException(String.format(MESSAGE_INVALID, value));
  }
}