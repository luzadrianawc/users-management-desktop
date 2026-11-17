package com.jcaa.usersmanagement.domain.exception;

public final class InvalidResearchProductIdException extends DomainException {

  private static final String MESSAGE_EMPTY = "The research product id must not be empty.";

  private InvalidResearchProductIdException(final String message) {
    super(message);
  }

  public static InvalidResearchProductIdException becauseValueIsEmpty() {
    return new InvalidResearchProductIdException(MESSAGE_EMPTY);
  }
}