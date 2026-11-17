package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.CreateResearchProductUseCase;
import com.jcaa.usersmanagement.application.port.out.GetResearchProductByIdPort;
import com.jcaa.usersmanagement.application.port.out.SaveResearchProductPort;
import com.jcaa.usersmanagement.application.service.dto.command.CreateResearchProductCommand;
import com.jcaa.usersmanagement.application.service.mapper.ResearchProductApplicationMapper;
import com.jcaa.usersmanagement.domain.exception.ResearchProductAlreadyExistsException;
import com.jcaa.usersmanagement.domain.model.ResearchProductModel;
import com.jcaa.usersmanagement.domain.valueobject.ResearchProductId;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import java.util.Set;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class CreateResearchProductService implements CreateResearchProductUseCase {

  private final SaveResearchProductPort saveResearchProductPort;
  private final GetResearchProductByIdPort getResearchProductByIdPort;
  private final Validator validator;

  @Override
  public ResearchProductModel execute(final CreateResearchProductCommand command) {
    validateCommand(command);

    final ResearchProductId id = new ResearchProductId(command.id());
    ensureIdIsNotTaken(id);

    final ResearchProductModel productToSave =
        ResearchProductApplicationMapper.fromCreateCommandToModel(command);
    return saveResearchProductPort.save(productToSave);
  }

  private void validateCommand(final CreateResearchProductCommand command) {
    final Set<ConstraintViolation<CreateResearchProductCommand>> violations =
        validator.validate(command);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
  }

  private void ensureIdIsNotTaken(final ResearchProductId id) {
    getResearchProductByIdPort
        .getById(id)
        .ifPresent(
            ignored -> {
              throw ResearchProductAlreadyExistsException.becauseIdAlreadyExists(id.value());
            });
  }
}