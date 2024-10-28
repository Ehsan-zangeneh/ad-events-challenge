package com.domain.challenge.service;

import com.domain.challenge.dto.ImpressionDto;
import com.domain.challenge.model.Impression;
import com.domain.challenge.repository.ImpressionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImpressionService {

  private final ImpressionRepository impressionRepository;

  public void save(ImpressionDto impressionDto) {
    impressionRepository.save(
        Impression.builder()
            .impressionId(impressionDto.getImpressionId())
            .advertiserId(impressionDto.getAdvertiserId())
            .appId(impressionDto.getAppId())
            .countryCode(impressionDto.getCountryCode())
            .build()
    );
  }



}
