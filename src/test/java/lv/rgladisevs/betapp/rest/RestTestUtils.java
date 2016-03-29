package lv.rgladisevs.betapp.rest;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import lv.rgladisevs.betapp.data.bet.Bet;

/**
 * Created by rihards.gladisevs on 2016.03.29..
 */
public class RestTestUtils {

  public static Bet getBetFromFile() throws IOException {
    URL url = Thread.currentThread().getContextClassLoader().getResource("bet.json");
    File file = new File(url.getPath());
    return new ObjectMapper().readValue(file, Bet.class);
  }

}
