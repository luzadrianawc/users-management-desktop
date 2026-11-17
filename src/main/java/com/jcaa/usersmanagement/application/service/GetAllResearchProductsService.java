package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.GetAllResearchProductsUseCase;
import com.jcaa.usersmanagement.application.port.out.GetAllResearchProductsPort;
import com.jcaa.usersmanagement.domain.model.ResearchProductModel;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class GetAllResearchProductsService implements GetAllResearchProductsUseCase {

  private final GetAllResearchProductsPort getAllResearchProductsPort;

  @Override
  public List<ResearchProductModel> execute() {
    return getAllResearchProductsPort.getAll();
  }
}