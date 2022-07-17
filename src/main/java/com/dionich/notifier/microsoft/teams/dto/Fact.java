package com.dionich.notifier.microsoft.teams.dto;

import lombok.Data;

@Data
public class Fact {

   private String name;

   private String value;

   public Fact(String name, String value) {
      this.name = name;
      this.value = value;
   }

}
