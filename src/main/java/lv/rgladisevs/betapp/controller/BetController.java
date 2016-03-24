package lv.rgladisevs.betapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import lv.rgladisevs.betapp.data.bet.Bet;
import lv.rgladisevs.betapp.data.bet.BetService;
import lv.rgladisevs.betapp.data.bet.option.BetOption;
import lv.rgladisevs.betapp.data.bet.option.BetOptionStorageService;
import lv.rgladisevs.betapp.data.message.Message;

/**
 * Created by rihards.gladisevs on 2016.03.23..
 */
@Controller
public class BetController {

  private static final Logger log = LoggerFactory.getLogger(BetController.class);

  @Autowired
  private BetOptionStorageService betOptionStorageService;

  @Autowired
  private BetService betService;

  @MessageMapping("/bet")
  @SendTo("/topic/warn")
  public Message saveBet(Bet bet) throws Exception {
    BetOption betOption = betOptionStorageService.getBetOptionFromMap(bet.getName());
    if (betOption != null) {
      if (betOption.getDatetime().equals(bet.getBetOptionDatetime())) {
        bet = betService.saveBet(bet);
        log.debug("Saving bet: {}", bet);
        return new Message("Success", "Your bet was successfully saved");
      } else {
        log.debug("Bet option was updated!");
        return new Message("Warn", "Bet option was updated, please save ticket, with newer bet");
      }
    } else {
      log.warn("Bet option not exists saveBet({})", bet);
      return new Message("Error", "Placing not existent bet");
    }
  }

}
