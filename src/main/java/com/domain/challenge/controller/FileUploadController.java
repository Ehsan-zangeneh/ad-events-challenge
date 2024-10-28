package com.domain.challenge.controller;

import com.domain.challenge.common.JsonFileParser;
import com.domain.challenge.dto.ImpressionDto;
import com.domain.challenge.service.ImpressionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/event/upload")
@Slf4j
public class FileUploadController {

  private final JsonFileParser jsonFileParser;
  private final ImpressionService impressionService;

  @PostMapping
  public ResponseEntity<String> uploadFiles(@RequestParam("impression") MultipartFile impression,
      @RequestParam("click") MultipartFile click) {
      log.info("Received files {}, {}", impression.getName(), click.getName());
      var impressionList = jsonFileParser.convertTo(impression, ImpressionDto.class);
      var clickList = jsonFileParser.convertTo(impression, ImpressionDto.class);
      impressionService.save(impressionList.get(0));
      return new ResponseEntity<>("Files are processed successfully", HttpStatus.CREATED);
  }

}
