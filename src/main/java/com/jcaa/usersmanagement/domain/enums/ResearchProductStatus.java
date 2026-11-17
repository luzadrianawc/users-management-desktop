package com.jcaa.usersmanagement.domain.enums;

import com.jcaa.usersmanagement.domain.exception.InvalidResearchProductStatusException;

public enum ResearchProductStatus {
  IN_DEVELOPMENT,
  PUBLISHED;

  public static ResearchProductStatus fromString(final String value) {
    for (final ResearchProductStatus status : values()) {
      if (status.name().equalsIgnoreCase(value)) {
        return status;
      }
    }
    throw InvalidResearchProductStatusException.becauseValueIsInvalid(value);
  }
}