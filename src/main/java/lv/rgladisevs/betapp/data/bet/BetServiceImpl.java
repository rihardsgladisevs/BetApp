package lv.rgladisevs.betapp.data.bet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by rihards.gladisevs on 2016.03.23..
 */
@Component
public class BetServiceImpl implements BetService {

  @Autowired
  private BetRepository betRepository;

  @Override
  public Bet saveBet(Bet bet) {
    return betRepository.save(bet);
  }

  @Override
  public Long getBetCountByIp(String ip) {
    return betRepository.countByIp(ip);
  }

  @Override
  public List<Bet> getBetListByNameAndOdd(String name, BigDecimal odd) {
    return betRepository.findByNameAndOdd(name, odd);
  }

  @Override
  public void deleteBetByTimestamp(Long timestamp) {
    betRepository.deleteByTimestamp(timestamp);
  }
}
