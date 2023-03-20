package com.dionich.notifier.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.dionich.notifier.microsoft.teams.service.MicrosoftTeamsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Startup implements ApplicationListener<ContextRefreshedEvent> {

   private final MicrosoftTeamsService microsoftTeamsService;

   public Startup(MicrosoftTeamsService microsoftTeamsService) {
      this.microsoftTeamsService = microsoftTeamsService;
   }

   public void onApplicationEvent(ContextRefreshedEvent event) {
      // make something that throw an exception

      try {
         int i = 1 / 0;
      } catch (Exception e) {
         log.error("Error sending message", e);
         microsoftTeamsService.sendMessage(e);
      }finally {
         try {
            Thread.sleep(5000);
         } catch (InterruptedException e) {
            throw new RuntimeException(e);
         }
      }
   }

}
