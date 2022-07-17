package com.dionich.notifier.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ApplicationInfo {

   public static String getApplicationName() {
      return "Notifier";
   }

   public static String getHostName() {
      try {
         return InetAddress.getLocalHost().getHostName();
      } catch (UnknownHostException e) {
         return "Unknown";
      }
   }

}
