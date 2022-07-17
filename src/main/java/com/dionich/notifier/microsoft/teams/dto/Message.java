package com.dionich.notifier.microsoft.teams.dto;

import static com.dionich.notifier.util.ApplicationInfo.getApplicationName;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.StyleConstants;

import org.springframework.boot.ansi.AnsiColors;

import com.dionich.notifier.microsoft.teams.util.FactsGenerator;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Message {

   @SerializedName("@type")
   private String type = "MessageCard";

   private String themeColor;

   private String summary = "Exception encountered on %s";

   private ArrayList<Section> sections;

   @SerializedName("potentialAction")
   private ArrayList<PotentialAction> potentialActions;

   public Message(Color color, String systemName, ArrayList<Section> sections, ArrayList<PotentialAction> potentialActions) {
      final String hexColor = Integer.toHexString(color.getRGB());
      this.setThemeColor(hexColor.substring(hexColor.length()-6));
      this.summary = String.format(summary, systemName);
      this.sections = sections;
      this.potentialActions = potentialActions;
   }

   public Message(String hexColor, String systemName, ArrayList<Section> sections, ArrayList<PotentialAction> potentialActions){
      this.setThemeColor(hexColor);
      this.summary = String.format(summary, systemName);
      this.sections = sections;
      this.potentialActions = potentialActions;
   }

   public Message(Exception exception){
      this.setThemeColor(Color.RED);
      this.summary = String.format(summary, "An error has been encountered on " + getApplicationName());
      this.sections = new ArrayList<>();
      this.potentialActions = new ArrayList<>();

      //TODO; Add error image
      this.sections.add(new Section(exception));

      //TODO; Add info image
      Section projectInfo = new Section();
      projectInfo.setActivityTitle("Project Info");
      projectInfo.setFacts(FactsGenerator.getProjectInfo());

      this.sections.add(projectInfo);

      this.potentialActions.add(
            new PotentialAction(
                  "OpenUri",
                  "Abrir repositorio de GitLab",
                  new ArrayList<>(){{
                     add(new HashMap<>(){{
                        put("os", "default");
                        put("uri", "https://gitlab.nacionservicios.com.ar");
                     }});
                  }}
            )
      );
   }

   public void setThemeColor(Color themeColor) {
      final String hexColor = Integer.toHexString(themeColor.getRGB());
      this.setThemeColor(hexColor.substring(hexColor.length()-6));
   }

   public void setThemeColor(String themeColor) {
      this.themeColor = themeColor.replace("#", "");
      if (themeColor.matches("[0-9a-fA-F]{6}")) {
         this.themeColor = themeColor;
      } else {
         throw new IllegalArgumentException("themeColor must be a hex color code");
      }
   }

   public void setType(String type) {
      this.type = type == null ? "MessageCard" : type;
   }

}
