package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.DeleteResearchProductUseCase;
import com.jcaa.usersmanagement.application.port.out.DeleteResearchProductPort;
import com.jcaa.usersmanagement.application.port.out.GetResearchProductByIdPort;
import com.jcaa.usersmanagement.application.service.dto.command.DeleteResearchProductCommand;
import com.jcaa.usersmanagement.application.service.mapper.ResearchProductApplicationMapper;
import com.jcaa.usersmanagement.domain.exception.ResearchProductNotFoundException;
import com.jcaa.usersmanagement.domain.valueobject.ResearchProductId;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import java.util.Set;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class DeleteResearchProductService implements DeleteResearchProductUseCase {

  private final DeleteResearchProductPort deleteResearchProductPort;
  private final GetResearchProductByIdPort getResearchProductByIdPort;
  private final Validator validator;

  @Override
  public void execute(final DeleteResearchProductCommand command) {
    validateCommand(command);

    final ResearchProductId id = ResearchProductApplicationMapper.fromDeleteCommandToId(command);
    ensureProductExists(id);
    deleteResearchProductPort.delete(id);
  }

  private void validateCommand(final DeleteResearchProductCommand command) {
    final Set<ConstraintViolation<DeleteResearchProductCommand>> violations =
        validator.validate(command);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
  }

  private void ensureProductExists(final ResearchProductId id) {
    getResearchProductByIdPort
        .getById(id)
        .orElseThrow(() -> ResearchProductNotFoundException.becauseIdWasNotFound(id.value()));
  }
}