package com.domain.challenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ClickDto {

  @JsonProperty("impression_id")
  String impressionId;

  double revenue;

}
