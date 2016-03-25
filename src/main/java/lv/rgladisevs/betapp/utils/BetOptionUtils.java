package lv.rgladisevs.betapp.utils;

import java.math.BigDecimal;
import java.util.Random;

import lv.rgladisevs.betapp.data.bet.option.odd.BetOptionOdd;

import static lv.rgladisevs.betapp.data.bet.option.odd.BetOptionOddType.ODD_TYPE_1X2;

/**
 * Created by rihards.gladisevs on 2016.03.23..
 */
public class BetOptionUtils {

  private static final double[] WIN_LOSE_COEFFICIENT_RANGE = {1.0, 3.0};
  private static final double[] DRAW_COEFFICIENT_RANGE = {3.0, 4.0};

  public static BetOptionOdd generateRandomBetOptionOdd() {
    BigDecimal win = BetOptionUtils.getRandomCoefficient(WIN_LOSE_COEFFICIENT_RANGE);
    BigDecimal draw = BetOptionUtils.getRandomCoefficient(DRAW_COEFFICIENT_RANGE);
    BigDecimal lose = BetOptionUtils.getRandomCoefficient(WIN_LOSE_COEFFICIENT_RANGE);
    return new BetOptionOdd(ODD_TYPE_1X2, win, draw, lose);
  }

  public static BigDecimal getRandomCoefficient(double[] range) {
    Random random = new Random();
    return new BigDecimal(range[0] + (range[1] - range[0]) + random.nextDouble())
        .setScale(2, BigDecimal.ROUND_HALF_UP);
  }

}
