package com.crud.tasks.controller.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloAttachementsByType {
    @JsonProperty("trello")
    private Trello trello;
}
