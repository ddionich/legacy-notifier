package com.dionich.notifier.microsoft.teams.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dionich.notifier.microsoft.teams.dto.Message;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MicrosoftTeamsService {

   @Value("${notifier.microsoft.teams.webhook.url}")
   private String WEBHOOK_URL;

   public void sendMessage(Exception exception) {
      sendToWebhook(new Gson().toJson(new Message(exception)));
   }

   public void sendMessage(Message message) {
      sendToWebhook(new Gson().toJson(message));
   }

   private void sendToWebhook(String value) {
      HttpRequest request = HttpRequest
            .newBuilder()
            .uri(URI.create(WEBHOOK_URL))
            .timeout(Duration.ofMinutes(2))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(value))
            .build();

      HttpClient.newHttpClient().sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(System.out::println);
   }

}
