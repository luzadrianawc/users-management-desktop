package com.jcaa.usersmanagement.domain.model;

import com.jcaa.usersmanagement.domain.enums.ResearchProductCategory;
import com.jcaa.usersmanagement.domain.enums.ResearchProductStatus;
import com.jcaa.usersmanagement.domain.enums.ResearchProductType;
import com.jcaa.usersmanagement.domain.valueobject.ResearchProductId;
import com.jcaa.usersmanagement.domain.valueobject.ResearchProductName;
import com.jcaa.usersmanagement.domain.valueobject.ResearchProductPoints;
import lombok.Value;

@Value
public class ResearchProductModel {

  ResearchProductId id;
  ResearchProductName name;
  ResearchProductType type;
  ResearchProductPoints points;
  ResearchProductStatus status;

  public static ResearchProductModel create(
      final ResearchProductId id,
      final ResearchProductName name,
      final ResearchProductType type,
      final ResearchProductPoints points) {
    return new ResearchProductModel(id, name, type, points, ResearchProductStatus.IN_DEVELOPMENT);
  }

  public ResearchProductModel publish() {
    return new ResearchProductModel(id, name, type, points, ResearchProductStatus.PUBLISHED);
  }

  public ResearchProductCategory category() {
    return points.category();
  }
}