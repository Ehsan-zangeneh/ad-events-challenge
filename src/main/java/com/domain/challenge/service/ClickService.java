package com.domain.challenge.service;

import com.domain.challenge.dto.ClickDto;
import com.domain.challenge.model.Click;
import com.domain.challenge.repository.ClickRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClickService {

  private final ClickRepository clickRepository;

  public void save(ClickDto clickDto) {

    clickRepository.save(Click.builder()
            .revenue(clickDto.getRevenue())
            .impressionId(clickDto.getImpressionId())
        .build());
  }



}
