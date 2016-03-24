package lv.rgladisevs.betapp.data.bet;

import java.io.Serializable;

/**
 * Created by rihards.gladisevs on 2016.03.23..
 */
public class BetPK implements Serializable {

  private Long timestamp;

  private String ip;

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }
}
