package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.model.ResearchProductModel;

public interface SaveResearchProductPort {
  ResearchProductModel save(ResearchProductModel product);
}