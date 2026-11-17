package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.GetResearchProductByIdUseCase;
import com.jcaa.usersmanagement.application.port.out.GetResearchProductByIdPort;
import com.jcaa.usersmanagement.application.service.dto.query.GetResearchProductByIdQuery;
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
public final class GetResearchProductByIdService implements GetResearchProductByIdUseCase {

  private final GetResearchProductByIdPort getResearchProductByIdPort;
  private final Validator validator;

  @Override
  public ResearchProductModel execute(final GetResearchProductByIdQuery query) {
    validateQuery(query);

    final ResearchProductId id = ResearchProductApplicationMapper.fromGetByIdQueryToId(query);
    return getResearchProductByIdPort
        .getById(id)
        .orElseThrow(() -> ResearchProductNotFoundException.becauseIdWasNotFound(id.value()));
  }

  private void validateQuery(final GetResearchProductByIdQuery query) {
    final Set<ConstraintViolation<GetResearchProductByIdQuery>> violations =
        validator.validate(query);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
  }
}