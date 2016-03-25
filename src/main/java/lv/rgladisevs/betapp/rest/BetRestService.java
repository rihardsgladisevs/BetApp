package lv.rgladisevs.betapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lv.rgladisevs.betapp.data.bet.option.BetOption;
import lv.rgladisevs.betapp.data.bet.option.BetOptionStorageService;

/**
 * Created by rihards.gladisevs on 2016.03.25..
 */
@RestController
@RequestMapping("/rest/bets")
public class BetRestService {

  @Autowired
  private BetOptionStorageService betOptionStorageService;

  @RequestMapping("/")
  public List<BetOption> getBetOptionList() {
    return betOptionStorageService.getBetOptionList();
  }

}
