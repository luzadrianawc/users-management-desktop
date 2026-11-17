package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.application.service.dto.query.GetResearchProductByIdQuery;
import com.jcaa.usersmanagement.domain.model.ResearchProductModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface GetResearchProductByIdUseCase {
  ResearchProductModel execute(@NotNull @Valid GetResearchProductByIdQuery query);
}