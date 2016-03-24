package lv.rgladisevs.betapp.data.bet.option;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;

import lv.rgladisevs.betapp.data.match.Match;
import lv.rgladisevs.betapp.data.match.MatchService;
import lv.rgladisevs.betapp.utils.BetOptionUtils;

/**
 * Created by rihards.gladisevs on 2016.03.20..
 */
@Service
public class BetOptionGenerationService {

  private static final Logger log = LoggerFactory.getLogger(BetOptionGenerationService.class);

  @Autowired
  private MatchService matchService;

  @Autowired
  private BetOptionObserverService betOptionObserverService;

  @Scheduled(fixedRate = 10000)
  private void generateAndUpdateBetOptions() throws BrokenBarrierException, InterruptedException {
    List<Match> matchList = matchService.getAllMatches();
    int index = new Random().nextInt(matchList.size());
    Match randomMatch = matchList.get(index);
    betOptionObserverService.addBetOptionToObservable(
        new BetOption(randomMatch.getName(), BetOptionUtils.generateRandomBetOptionOdd()));
  }
}
