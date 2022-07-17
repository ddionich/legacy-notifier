package com.dionich.notifier.microsoft.teams.dto;

import static com.dionich.notifier.microsoft.teams.util.FactsGenerator.getExceptionInfo;
import static com.dionich.notifier.util.ApplicationInfo.getApplicationName;
import static com.dionich.notifier.util.ApplicationInfo.getHostName;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Section {

   private String activityTitle;

   private String activitySubtitle;

   private String activityImage;

   private String text;

   private ArrayList<Fact> facts;

   private boolean markdown = true;

   public Section(Exception exception){
      this.activityTitle = "Error encountered on %s".replace("%s", getApplicationName());
      this.activitySubtitle = exception.getClass().getSimpleName();
      this.text = "Detailed information about exception:";
      this.facts = getExceptionInfo(exception);
   }

}
