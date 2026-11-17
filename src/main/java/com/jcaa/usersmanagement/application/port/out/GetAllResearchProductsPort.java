package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.model.ResearchProductModel;
import java.util.List;

public interface GetAllResearchProductsPort {
  List<ResearchProductModel> getAll();
}