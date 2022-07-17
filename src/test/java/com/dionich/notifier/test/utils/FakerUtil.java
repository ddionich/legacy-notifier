package com.dionich.notifier.test.utils;

import com.github.javafaker.Faker;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class FakerUtil {

   private static Faker faker;

   private static Faker getFaker() {
      if (faker == null)
         faker = new Faker();
      return faker;
   }

   public static String generateUsername() {
      String username = getFaker().name().username();
      log.info("username generated: {}", username);
      return username;
   }

   public static String generateCompany() {
      String company = getFaker().company().name();
      log.info("company generated: {}", company);
      return company;
   }

   public static Long generateRandomLong() {
      Long number = getFaker().number().numberBetween(0, 99999L);
      log.info("number generated: {}", number);
      return number;
   }

   public static String generateText() {
      String username = getFaker().lorem().paragraph();
      log.info("text generated: {}", username);
      return username;
   }

   //generate system name
   public static String generateSystemName() {
      String systemName = getFaker().leagueOfLegends().champion();
      log.info("system name generated: {}", systemName);
      return systemName;
   }

}

