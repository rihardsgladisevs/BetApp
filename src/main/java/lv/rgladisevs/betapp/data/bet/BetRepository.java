package lv.rgladisevs.betapp.data.bet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rihards.gladisevs on 2016.03.23..
 */
@Repository
public interface BetRepository extends CrudRepository<Bet, BetPK> {

  Long countByIp(String ip);
  List<Bet> findByNameAndType(String name, String type);
  void deleteByTimestamp(Long timestamp);
}
