package com.jcaa.usersmanagement.domain.exception;

public final class ResearchProductNotFoundException extends DomainException {

  private static final String MESSAGE_BY_ID = "The research product with id '%s' was not found.";

  private ResearchProductNotFoundException(final String message) {
    super(message);
  }

  public static ResearchProductNotFoundException becauseIdWasNotFound(final String id) {
    return new ResearchProductNotFoundException(String.format(MESSAGE_BY_ID, id));
  }
}