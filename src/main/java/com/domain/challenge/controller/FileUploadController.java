package com.domain.challenge.controller;

import com.domain.challenge.common.JsonFileParser;
import com.domain.challenge.dto.ClickDto;
import com.domain.challenge.dto.ImpressionDto;
import com.domain.challenge.service.ClickService;
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
  private final ClickService clickService;

  @PostMapping
  public ResponseEntity<String> uploadFiles(@RequestParam("impression") MultipartFile impressionFile,
      @RequestParam("click") MultipartFile clickFile) {
      log.info("Received files {}, {}", impressionFile.getName(), clickFile.getName());
      var impressionList = jsonFileParser.convertTo(impressionFile, ImpressionDto.class);
      var clickList = jsonFileParser.convertTo(clickFile, ClickDto.class);
      impressionService.saveAll(impressionList);
      clickService.saveAll(clickList);
      return new ResponseEntity<>("Files are processed successfully", HttpStatus.CREATED);
  }

}
