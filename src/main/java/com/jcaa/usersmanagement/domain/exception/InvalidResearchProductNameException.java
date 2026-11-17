package com.jcaa.usersmanagement.domain.exception;

public final class InvalidResearchProductNameException extends DomainException {

  private static final String MESSAGE_EMPTY = "The research product name must not be empty.";
  private static final String MESSAGE_TOO_SHORT =
      "The research product name must have at least %d characters.";

  private InvalidResearchProductNameException(final String message) {
    super(message);
  }

  public static InvalidResearchProductNameException becauseValueIsEmpty() {
    return new InvalidResearchProductNameException(MESSAGE_EMPTY);
  }

  public static InvalidResearchProductNameException becauseLengthIsTooShort(final int minimum) {
    return new InvalidResearchProductNameException(String.format(MESSAGE_TOO_SHORT, minimum));
  }
}