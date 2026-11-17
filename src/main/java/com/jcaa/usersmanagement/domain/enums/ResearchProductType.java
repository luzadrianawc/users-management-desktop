package com.jcaa.usersmanagement.domain.enums;

import com.jcaa.usersmanagement.domain.exception.InvalidResearchProductTypeException;

public enum ResearchProductType {
  ARTICLE,
  CONFERENCE_PAPER,
  BOOK,
  SOFTWARE,
  PATENT;

  public static ResearchProductType fromString(final String value) {
    for (final ResearchProductType type : values()) {
      if (type.name().equalsIgnoreCase(value)) {
        return type;
      }
    }
    throw InvalidResearchProductTypeException.becauseValueIsInvalid(value);
  }
}