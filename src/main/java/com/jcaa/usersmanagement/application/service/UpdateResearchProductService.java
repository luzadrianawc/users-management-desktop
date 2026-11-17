package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.UpdateResearchProductUseCase;
import com.jcaa.usersmanagement.application.port.out.GetResearchProductByIdPort;
import com.jcaa.usersmanagement.application.port.out.UpdateResearchProductPort;
import com.jcaa.usersmanagement.application.service.dto.command.UpdateResearchProductCommand;
import com.jcaa.usersmanagement.application.service.mapper.ResearchProductApplicationMapper;
import com.jcaa.usersmanagement.domain.exception.ResearchProductNotFoundException;
import com.jcaa.usersmanagement.domain.model.ResearchProductModel;
import com.jcaa.usersmanagement.domain.valueobject.ResearchProductId;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import java.util.Set;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class UpdateResearchProductService implements UpdateResearchProductUseCase {

  private final UpdateResearchProductPort updateResearchProductPort;
  private final GetResearchProductByIdPort getResearchProductByIdPort;
  private final Validator validator;

  @Override
  public ResearchProductModel execute(final UpdateResearchProductCommand command) {
    validateCommand(command);

    final ResearchProductId id = new ResearchProductId(command.id());
    ensureProductExists(id);

    final ResearchProductModel productToUpdate =
        ResearchProductApplicationMapper.fromUpdateCommandToModel(command);
    return updateResearchProductPort.update(productToUpdate);
  }

  private void validateCommand(final UpdateResearchProductCommand command) {
    final Set<ConstraintViolation<UpdateResearchProductCommand>> violations =
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