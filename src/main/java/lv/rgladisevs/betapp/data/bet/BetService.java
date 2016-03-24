package lv.rgladisevs.betapp.data.bet;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by rihards.gladisevs on 2016.03.23..
 */
public interface BetService {

  Bet saveBet(Bet bet);

  Long getBetCountByIp(String ip);

  List<Bet> getBetListByNameAndOdd(String name, BigDecimal odd);

  void deleteBetByTimestamp(Long timestamp);
}
