package lv.rgladisevs.betapp.data.bet.option;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by rihards.gladisevs on 2016.03.20..
 */
@Service
@Scope(scopeName = "application")
public class BetOptionStorageServiceImpl implements BetOptionStorageService {

  private static final Logger log = LoggerFactory.getLogger(BetOptionStorageServiceImpl.class);

  private ConcurrentHashMap<String, BetOption> betOptionMap = new ConcurrentHashMap<>();

  @Override
  public BetOption getBetOptionFromMap(String matchName) {
    return betOptionMap.get(matchName);
  }

  @Override
  public void updateOptionInMap(BetOption betOption) {
    this.betOptionMap.put(betOption.getName(), betOption);
    log.debug("Bet option map updated: {}", betOptionMap);
  }

  @Override
  public List<BetOption> getBetOptionList() {
    return new ArrayList<>(betOptionMap.values());
  }
}
