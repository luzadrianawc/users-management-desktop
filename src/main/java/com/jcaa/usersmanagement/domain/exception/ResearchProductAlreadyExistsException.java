package com.jcaa.usersmanagement.domain.exception;

public final class ResearchProductAlreadyExistsException extends DomainException {

  private static final String MESSAGE_BY_ID = "The research product with id '%s' already exists.";

  private ResearchProductAlreadyExistsException(final String message) {
    super(message);
  }

  public static ResearchProductAlreadyExistsException becauseIdAlreadyExists(final String id) {
    return new ResearchProductAlreadyExistsException(String.format(MESSAGE_BY_ID, id));
  }
}
