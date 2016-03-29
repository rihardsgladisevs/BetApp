package lv.rgladisevs.betapp;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import lv.rgladisevs.betapp.data.bet.Bet;
import lv.rgladisevs.betapp.data.match.Match;

/**
 * Created by rihards.gladisevs on 2016.03.29..
 */
public class TestUtils {

  public static Bet getBetFromFile() throws IOException {
    return new ObjectMapper().readValue(getFile("bet.json"), Bet.class);
  }

  public static Match getMatchFromFile() throws IOException {
    return new ObjectMapper().readValue(getFile("match.json"), Match.class);
  }

  private static File getFile(String filePathRelativeToResourceFolder) {
    URL url = Thread.currentThread()
        .getContextClassLoader().getResource(filePathRelativeToResourceFolder);
    return new File(url.getPath());
  }

}
