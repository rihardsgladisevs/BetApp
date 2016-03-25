package lv.rgladisevs.betapp.data.bet;

import java.util.List;

/**
 * Created by rihards.gladisevs on 2016.03.23..
 */
public interface BetService {

  Bet saveBet(Bet bet);

  Long getBetCountByIp(String ip);

  List<Bet> getBetListByNameAndType(String name, String type);

  void deleteBetByTimestamp(Long timestamp);
}
