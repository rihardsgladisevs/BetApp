package lv.rgladisevs.betapp.data.bet.option.odd;

/**
 * Created by rihards.gladisevs on 2016.03.20..
 */
public enum BetOptionOddType {
  ODD_TYPE_1X2("1x2");

  private String name;

  BetOptionOddType(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
