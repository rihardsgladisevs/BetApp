package lv.rgladisevs.betapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import lv.rgladisevs.betapp.data.bet.option.BetOptionSubscriptionService;
import lv.rgladisevs.betapp.data.match.Match;
import lv.rgladisevs.betapp.data.match.MatchService;

/**
 * Created by rihards.gladisevs on 2016.03.20..
 */
@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

  @Autowired
  private BetOptionSubscriptionService betOptionSubscriptionService;

  @Autowired
  private MatchService matchService;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    this.matchService.saveMatch(new Match("Russia - France"));
    this.matchService.saveMatch(new Match("Germany - Italy"));

    betOptionSubscriptionService.initBetOptionSubscription();
  }

}
