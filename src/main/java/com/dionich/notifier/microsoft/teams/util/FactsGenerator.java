package com.dionich.notifier.microsoft.teams.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import com.dionich.notifier.microsoft.teams.dto.Fact;
import com.dionich.notifier.util.ApplicationInfo;

public class FactsGenerator {

   public static ArrayList<Fact> getExceptionInfo(Throwable exception){

      ArrayList<Fact> facts = new ArrayList<Fact>();
      facts.add(new Fact("Error", exception.toString() ));
      facts.add(new Fact("Class", exception.getClass().getCanonicalName() ));
      facts.add(new Fact("Message", exception.getMessage()));
      facts.add(new Fact("Cause", exception.getCause() != null ? exception.getCause().toString() : "Unknown cause"));
      facts.add(new Fact("Exception", exception.getClass().getSimpleName()));

      if (Objects.nonNull(exception.getStackTrace())) {
         facts.add(new Fact("Stack Trace", Arrays.stream(exception.getStackTrace())
               .map(StackTraceElement::toString)
               .limit(5L)
               .collect(Collectors.joining("\n"))));
      }

      return facts;
   }

   public static ArrayList<Fact> getProjectInfo() {
      ArrayList<Fact> facts = new ArrayList<Fact>();

      facts.add(new Fact("Version", "1.0.0"));
      facts.add(new Fact("Ambiente", "Producción"));
      facts.add(new Fact("Host", ApplicationInfo.getHostName()));
      facts.add(new Fact("Equipo", "Redes de carga"));
      facts.add(new Fact("Fecha", LocalDateTime.now().toString()));

      return facts;
   }

}
