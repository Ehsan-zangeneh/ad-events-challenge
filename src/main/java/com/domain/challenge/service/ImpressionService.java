package com.domain.challenge.service;

import com.domain.challenge.dto.ImpressionDto;
import com.domain.challenge.model.Impression;
import com.domain.challenge.repository.ImpressionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImpressionService {

  private final ImpressionRepository impressionRepository;

  public void saveAll(List<ImpressionDto> impressionDtoList) {
        var impressions = impressionDtoList.stream()
            .map(this::convert)
            .toList();
        //this needs to be checked whether it does
        //  the bulk insert properly or not.
        impressionRepository.saveAll(impressions);
  }


  private Impression convert(ImpressionDto impressionDto) {
    return Impression.builder()
            .impressionId(impressionDto.getImpressionId())
            .advertiserId(impressionDto.getAdvertiserId())
            .appId(impressionDto.getAppId())
            .countryCode(impressionDto.getCountryCode())
            .build();
  }

}
