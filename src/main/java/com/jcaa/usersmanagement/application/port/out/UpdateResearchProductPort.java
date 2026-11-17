package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.model.ResearchProductModel;

public interface UpdateResearchProductPort {
  ResearchProductModel update(ResearchProductModel product);
}
