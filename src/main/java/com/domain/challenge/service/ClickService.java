package com.domain.challenge.service;

import com.domain.challenge.dto.ClickDto;
import com.domain.challenge.model.Click;
import com.domain.challenge.repository.ClickRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClickService {

  private final ClickRepository clickRepository;

  public void saveAll(List<ClickDto> clickDtoList) {
    var clicks = clickDtoList.stream()
        .map(this::convert)
        .toList();
    clickRepository.saveAll(clicks);
  }

  private Click convert(ClickDto clickDto) {
    return Click.builder()
        .impressionId(clickDto.getImpressionId())
        .revenue(clickDto.getRevenue())
        .build();
  }

}
