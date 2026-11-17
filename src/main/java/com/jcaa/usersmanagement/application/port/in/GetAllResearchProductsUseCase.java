package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.domain.model.ResearchProductModel;
import java.util.List;

public interface GetAllResearchProductsUseCase {
  List<ResearchProductModel> execute();
}