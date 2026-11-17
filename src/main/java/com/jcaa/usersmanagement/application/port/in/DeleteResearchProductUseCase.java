package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.application.service.dto.command.DeleteResearchProductCommand;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface DeleteResearchProductUseCase {
  void execute(@NotNull @Valid DeleteResearchProductCommand command);
}