package com.jcaa.usersmanagement.application.service.mapper;

import com.jcaa.usersmanagement.application.service.dto.command.CreateResearchProductCommand;
import com.jcaa.usersmanagement.application.service.dto.command.DeleteResearchProductCommand;
import com.jcaa.usersmanagement.application.service.dto.command.UpdateResearchProductCommand;
import com.jcaa.usersmanagement.application.service.dto.query.GetResearchProductByIdQuery;
import com.jcaa.usersmanagement.domain.enums.ResearchProductStatus;
import com.jcaa.usersmanagement.domain.enums.ResearchProductType;
import com.jcaa.usersmanagement.domain.model.ResearchProductModel;
import com.jcaa.usersmanagement.domain.valueobject.ResearchProductId;
import com.jcaa.usersmanagement.domain.valueobject.ResearchProductName;
import com.jcaa.usersmanagement.domain.valueobject.ResearchProductPoints;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ResearchProductApplicationMapper {

  public ResearchProductModel fromCreateCommandToModel(
      final CreateResearchProductCommand command) {
    return ResearchProductModel.create(
        new ResearchProductId(command.id()),
        new ResearchProductName(command.name()),
        ResearchProductType.fromString(command.type()),
        new ResearchProductPoints(command.points()));
  }

  public ResearchProductModel fromUpdateCommandToModel(
      final UpdateResearchProductCommand command) {
    return new ResearchProductModel(
        new ResearchProductId(command.id()),
        new ResearchProductName(command.name()),
        ResearchProductType.fromString(command.type()),
        new ResearchProductPoints(command.points()),
        ResearchProductStatus.fromString(command.status()));
  }

  public ResearchProductId fromDeleteCommandToId(final DeleteResearchProductCommand command) {
    return new ResearchProductId(command.id());
  }

  public ResearchProductId fromGetByIdQueryToId(final GetResearchProductByIdQuery query) {
    return new ResearchProductId(query.id());
  }
}