package lv.rgladisevs.betapp.data.bet.option.odd;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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

  @JsonCreator
  public static BetOptionOddType forValue(String value) {
    for (BetOptionOddType betOptionOddType : BetOptionOddType.values()) {
      if (betOptionOddType.getName().equals(value)) {
        return betOptionOddType;
      }
    }
    return null;
  }

  @JsonValue
  public String toValue() {
    return this.name;
  }
}
