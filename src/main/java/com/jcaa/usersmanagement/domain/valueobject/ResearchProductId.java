package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.exception.InvalidResearchProductIdException;
import java.util.Objects;

public record ResearchProductId(String value) {

  public ResearchProductId {
    final String normalizedValue =
        Objects.requireNonNull(value, "ResearchProductId cannot be null").trim();
    validateNotEmpty(normalizedValue);
    value = normalizedValue;
  }

  private static void validateNotEmpty(final String normalizedValue) {
    if (normalizedValue.isEmpty()) {
      throw InvalidResearchProductIdException.becauseValueIsEmpty();
    }
  }

  @Override
  public String toString() {
    return value;
  }
}