package com.jcaa.usersmanagement.domain.enums;

public enum ResearchProductCategory {
  A,
  B,
  C,
  D,
  E;

  public static ResearchProductCategory fromPoints(final int points) {
    if (points >= 10) {
      return A;
    }
    if (points >= 8) {
      return B;
    }
    if (points >= 6) {
      return C;
    }
    if (points >= 4) {
      return D;
    }
    return E;
  }
}