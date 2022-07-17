package com.dionich.notifier.microsoft.teams.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.springframework.stereotype.Service;

import com.dionich.notifier.microsoft.teams.Mock;
import com.dionich.notifier.microsoft.teams.dto.Message;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MicrosoftTeamsService {

   private final String url = "https://nacionserviciossl.webhook.office.com/webhookb2/8ebc8753-ac82-4bf8-8980-f73cf7ae2b92@55b0adbe-861e-4eb2-8543"
         + "-50fd870667eb/IncomingWebhook/317fff935772470aa75a7bb9020c610e/afa13a30-4df7-452e-bbb8-80c60a5a35b3";

   @Deprecated
   public void sendMessage(String message) {

      String value = new Gson().toJson(Mock.getMessage());
      System.out.println();
      System.out.println(value);
      System.out.println();

      HttpClient client = HttpClient.newHttpClient();

      HttpRequest request = HttpRequest
            .newBuilder()
            .uri(URI.create(url))
            .timeout(Duration.ofMinutes(2))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(value))
            .build();

      client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(System.out::println);

      try {
         Thread.sleep(5000);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }

   }

   public void sendMessage(Exception exception) {

      String value = new Gson().toJson(new Message(exception));
      System.out.println();
      System.out.println(value);
      System.out.println();

      HttpClient client = HttpClient.newHttpClient();

      HttpRequest request = HttpRequest
            .newBuilder()
            .uri(URI.create(url))
            .timeout(Duration.ofMinutes(2))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(value))
            .build();

      client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(System.out::println);

      try {
         Thread.sleep(5000);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
   }

   public void sendMessage(Message message) {

   }

}
