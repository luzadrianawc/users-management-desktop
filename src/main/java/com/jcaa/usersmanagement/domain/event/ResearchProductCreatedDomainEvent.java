package com.jcaa.usersmanagement.domain.event;

import com.jcaa.usersmanagement.domain.model.ResearchProductModel;
import java.util.Map;
import lombok.Getter;

@Getter
public final class ResearchProductCreatedDomainEvent extends DomainEvent {

  private static final String EVENT_NAME = "research-product.created";

  private final ResearchProductModel product;

  public ResearchProductCreatedDomainEvent(final ResearchProductModel product) {
    super(EVENT_NAME);
    this.product = product;
  }

  @Override
  public Map<String, String> payload() {
    return Map.of(
        "id", product.getId().value(),
        "name", product.getName().value(),
        "type", product.getType().name(),
        "points", String.valueOf(product.getPoints().value()),
        "status", product.getStatus().name());
  }
}