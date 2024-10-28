package com.domain.challenge.common;

import com.domain.challenge.common.exception.InvalidFileTypeException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Component
public class JsonFileParser {


  @SneakyThrows
  public <T> List<T> convertTo(MultipartFile jsonFile, Class<T> type) {
    if(!isFileTypeJson(jsonFile)) {
        throw new InvalidFileTypeException(
            "Invalid file type: Expected json but received %s".formatted(jsonFile.getContentType())
        );
    }
    log.info("parsing the file {}...", jsonFile.getName());
    var objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
    List<Map<String, Object>> rawJsonList = objectMapper.readValue(jsonFile.getBytes(),
        new TypeReference<>(){});
    List<T> jsonObjectList = new ArrayList<>();
    for (Map<String, Object> rawJson : rawJsonList) {
      try {
        T jsonObject = objectMapper.convertValue(rawJson, type);
        jsonObjectList.add(jsonObject);
      } catch (IllegalArgumentException e) {
        log.error("Skipping object due to unknown properties: {}",rawJson);
      }
    }
    return jsonObjectList;
  }

  private boolean isFileTypeJson(MultipartFile jsonFile) {
    return Objects.equals(CommonConstants.JSON_FILE_TYPE, jsonFile.getContentType());
  }

}
