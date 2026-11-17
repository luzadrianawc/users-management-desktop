package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.enums.ResearchProductCategory;
import com.jcaa.usersmanagement.domain.exception.InvalidResearchProductPointsException;

public record ResearchProductPoints(int value) {

  public ResearchProductPoints {
    if (value < 0) {
      throw InvalidResearchProductPointsException.becauseValueIsNegative(value);
    }
  }

  public ResearchProductCategory category() {
    return ResearchProductCategory.fromPoints(value);
  }
}