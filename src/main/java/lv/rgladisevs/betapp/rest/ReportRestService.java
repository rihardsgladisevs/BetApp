package lv.rgladisevs.betapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

import lv.rgladisevs.betapp.data.bet.Bet;
import lv.rgladisevs.betapp.data.bet.BetService;

/**
 * Created by rihards.gladisevs on 2016.03.24..
 */
@RestController
@RequestMapping("/reports")
public class ReportRestService {

  @Autowired
  private BetService betService;

  @RequestMapping("/ip/{ip}/count")
  public Long getBetCountByIp(@PathVariable String ip) {
    return betService.getBetCountByIp(ip);
  }

  @RequestMapping("/name/{name}")
  public List<Bet> getBetListByNameAndOdd(@PathVariable String name, @RequestParam BigDecimal odd) {
    return betService.getBetListByNameAndOdd(name, odd);
  }

  @RequestMapping(value = "/timestamp/{timestamp}", method = RequestMethod.DELETE)
  public void deleteBetByTimestamp(@PathVariable Long timestamp) {
    betService.deleteBetByTimestamp(timestamp);
  }
}
