package com.jcaa.usersmanagement.domain.exception;

public final class InvalidResearchProductPointsException extends DomainException {

  private static final String MESSAGE_NEGATIVE =
      "The research product points cannot be negative, but received %d.";

  private InvalidResearchProductPointsException(final String message) {
    super(message);
  }

  public static InvalidResearchProductPointsException becauseValueIsNegative(final int value) {
    return new InvalidResearchProductPointsException(String.format(MESSAGE_NEGATIVE, value));
  }
}