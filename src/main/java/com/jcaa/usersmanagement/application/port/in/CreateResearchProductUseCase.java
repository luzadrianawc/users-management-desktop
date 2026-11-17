package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.application.service.dto.command.CreateResearchProductCommand;
import com.jcaa.usersmanagement.domain.model.ResearchProductModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface CreateResearchProductUseCase {
  ResearchProductModel execute(@NotNull @Valid CreateResearchProductCommand command);
}