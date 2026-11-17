package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.model.ResearchProductModel;
import com.jcaa.usersmanagement.domain.valueobject.ResearchProductId;
import java.util.Optional;

public interface GetResearchProductByIdPort {
  Optional<ResearchProductModel> getById(ResearchProductId id);
}