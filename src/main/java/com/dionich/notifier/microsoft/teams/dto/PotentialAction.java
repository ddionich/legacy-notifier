package com.dionich.notifier.microsoft.teams.dto;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PotentialAction {

   @SerializedName("@type")
   private String type;

   private String name;

   private List<Map<String, String>> targets;

   public PotentialAction(String type, String name, List<Map<String, String>> targets) {
      this.type = type;
      this.name = name;
      this.targets = targets;
   }

}
