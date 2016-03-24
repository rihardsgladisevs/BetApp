package lv.rgladisevs.betapp.data.bet.option;

import java.util.Date;

import lv.rgladisevs.betapp.data.bet.option.odd.BetOptionOdd;

/**
 * Created by rihards.gladisevs on 2016.03.20..
 */
public class BetOption {

  private String name;
  private Long datetime;
  private BetOptionOdd odd;

  public BetOption(String name, BetOptionOdd odd) {
    this.name = name;
    this.odd = odd;
    this.datetime = new Date().getTime();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getDatetime() {
    return datetime;
  }

  public void setDatetime(Long datetime) {
    this.datetime = datetime;
  }

  public BetOptionOdd getOdd() {
    return odd;
  }

  public void setOdd(BetOptionOdd odd) {
    this.odd = odd;
  }

  @Override
  public String toString() {
    return "BetOption{" +
           "name='" + name + '\'' +
           ", datetime=" + datetime +
           ", odd=" + odd +
           '}';
  }
}
