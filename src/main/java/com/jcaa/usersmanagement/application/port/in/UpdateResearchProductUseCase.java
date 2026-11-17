package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.application.service.dto.command.UpdateResearchProductCommand;
import com.jcaa.usersmanagement.domain.model.ResearchProductModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface UpdateResearchProductUseCase {
  ResearchProductModel execute(@NotNull @Valid UpdateResearchProductCommand command);
}