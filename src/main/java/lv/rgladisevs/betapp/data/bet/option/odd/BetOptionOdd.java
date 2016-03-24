package lv.rgladisevs.betapp.data.bet.option.odd;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by rihards.gladisevs on 2016.03.20..
 */
public class BetOptionOdd implements Serializable {

  public BetOptionOdd(BetOptionOddType type, BigDecimal win, BigDecimal draw, BigDecimal lose) {
    this.type = type;
    this.win = win;
    this.draw = draw;
    this.lose = lose;
  }

  private BetOptionOddType type;

  private BigDecimal win;

  private BigDecimal draw;

  private BigDecimal lose;

  public BetOptionOddType getType() {
    return type;
  }

  public void setType(BetOptionOddType type) {
    this.type = type;
  }

  public BigDecimal getWin() {
    return win;
  }

  public void setWin(BigDecimal win) {
    this.win = win;
  }

  public BigDecimal getDraw() {
    return draw;
  }

  public void setDraw(BigDecimal draw) {
    this.draw = draw;
  }

  public BigDecimal getLose() {
    return lose;
  }

  public void setLose(BigDecimal lose) {
    this.lose = lose;
  }
}
