package com.dionich.notifier.microsoft.teams.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.dionich.notifier.test.utils.FakerUtil;

import lombok.extern.log4j.Log4j2;

@Log4j2
class MessageTest {

   @Nested
   class Constructor {

      @Test
      void should_get_correct_hex_color_for_red() {
         assertEquals("ff0000", new Message(Color.RED, null, new ArrayList<>(), new ArrayList<>()).getThemeColor());
      }

      @Test
      void should_get_correct_hex_color_for_blue() {
         assertEquals("0000ff", new Message(Color.BLUE, null, new ArrayList<>(), new ArrayList<>()).getThemeColor());
      }

      @Test
      void should_get_correct_message() {
         final String systemName = FakerUtil.generateSystemName();
         final Message message = new Message(Color.GREEN, systemName, new ArrayList<>(), new ArrayList<>());

         log.info(message);

         assertAll(
               () -> assertEquals("00ff00", message.getThemeColor()),
               () -> assertEquals("MessageCard", message.getType()),
               () -> assertEquals("Exception encountered on ".concat(systemName), message.getSummary()),
               () -> assertEquals("MessageCard", message.getType()),
               () -> assertEquals(new ArrayList<Section>(), message.getSections()),
               () -> assertEquals(new ArrayList<PotentialAction>(), message.getPotentialActions())
         );
      }

   }

}