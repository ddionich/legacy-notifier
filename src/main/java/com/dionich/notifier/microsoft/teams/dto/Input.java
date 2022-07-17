package com.dionich.notifier.microsoft.teams.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Input {

   @JsonProperty("@type")
   private String type;

   private String id;

   private boolean isMultiline;

   private String title;

   private String isMultiSelect;

   private ArrayList<Choice> choices;

}
