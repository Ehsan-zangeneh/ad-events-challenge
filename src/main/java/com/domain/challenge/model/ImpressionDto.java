package com.domain.challenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ImpressionDto {

  @JsonProperty("id")
  @NotNull
  String impressionId;

  @JsonProperty("app_id")
  @NotNull
  Integer appId;

  @JsonProperty("country_code")
  @Size(max = 2, message = "country code length must not exceed 2 letters")
  @NotNull
  String countryCode;

  @JsonProperty("advertiser_id")
  @NotNull
  Integer advertiserId;

}
