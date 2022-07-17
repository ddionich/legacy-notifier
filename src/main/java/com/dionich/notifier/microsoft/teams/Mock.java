package com.dionich.notifier.microsoft.teams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dionich.notifier.microsoft.teams.dto.Fact;
import com.dionich.notifier.microsoft.teams.dto.Message;
import com.dionich.notifier.microsoft.teams.dto.PotentialAction;
import com.dionich.notifier.microsoft.teams.dto.Section;

public class Mock {

   public static Message getMessage() {

      String type = "MessageCard";
      String themeColor = "FF0000";
      String summary = "Exception Encountered on DRM";

      Section section = new Section();
      section.setActivityTitle("Null Pointer Exception");
      section.setActivitySubtitle("On DRM");
      section.setActivityImage("https://www.freeiconspng.com/thumbs/error-icon/error-icon-32.png");
      section.setText(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris nec ullamcorper nulla. Mauris vulputate fermentum nisi. Donec commodo "
                  + "bibendum ipsum quis dignissim. Nulla eleifend mauris ipsum, sit amet molestie nisi elementum id. Etiam id libero id arcu "
                  + "dapibus hendrerit vitae ut orci. Duis egestas, turpis quis efficitur vehicula, felis justo placerat massa, eu porta tortor "
                  + "justo lacinia tellus. Mauris a velit nisi. Sed accumsan sed nisl accumsan tempus. Ut ac lorem in massa lacinia congue. Etiam "
                  + "ullamcorper augue quis ultricies facilisis.");
      section.setMarkdown(true);

      Fact fact1 = new Fact("Version", "1.0.0");
      Fact fact2 = new Fact("Ambiente", "Producción");
      Fact fact3 = new Fact("Host", "192.168.0.1");
      Fact fact4 = new Fact("Equipo", "Redes de carga");
      Fact fact5 = new Fact("Fecha", "Mon May 01 2017 17:07:18 GMT-0700");
      ArrayList<Fact> facts = new ArrayList<>();
      facts.add(fact1);
      facts.add(fact2);
      facts.add(fact3);
      facts.add(fact4);
      facts.add(fact5);

      section.setFacts(facts);

      ArrayList<Section> sections = new ArrayList<>(Collections.singleton(section));

      ArrayList<PotentialAction> potentialActions = new ArrayList<>();
      PotentialAction potentialAction1 = new PotentialAction();
      potentialAction1.setName("Abrir repositorio de GitLab");
      potentialAction1.setType("OpenUri");
      potentialActions.add(potentialAction1);

      Map<String, String> target = new HashMap<>();
      target.put("os", "default");
      target.put("uri", "https://gitlab.nacionservicios.com.ar");

      List<Map<String, String>> targets = new ArrayList<>(Collections.singleton(target));
      potentialAction1.setTargets(targets);

//      Message message = new Message(type, themeColor, summary, sections, potentialActions);

      return null;
   }

}
